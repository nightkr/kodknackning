package views.html.helpers

import replsampler.formatting.Formatter
import play.api.templates.Html
import replsampler.Runner.Result
import replsampler.ReplSampler

object sample {
  object KodknackningFormatter extends Formatter[Html]{
    override def apply(in: Seq[Result]): Html = sampleFormatter(in)
  }

  def apply(in: String): Html = ReplSampler.runAndFormat(in, KodknackningFormatter)
}
