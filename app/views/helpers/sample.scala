package views.html.helpers

import replsampler.formatting.Formatter
import play.api.templates.Html
import replsampler.Runner.Result
import replsampler.{Runner, ReplSampler}
import utils.Hash
import play.api.cache.Cache

object sample {
  object KodknackningFormatter extends Formatter[Html]{
    override def apply(in: Seq[Result]): Html = sampleFormatter(in)
  }

  def apply(in: String): Html = {
    val hash = Hash.SHA1(in).toHexString
    Cache.getOrElse[Html](s"sample.$hash") {
      ReplSampler.runAndFormat(in, KodknackningFormatter)
    }
  }

  def status2cssclass(r: Runner.ResultStatus) = r match {
    case Runner.CompileFail => "error"
    case Runner.RuntimeFail => "error"
    case Runner.Success => "success"
  }
}
