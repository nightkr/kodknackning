package views.html.helpers

import play.api.templates.Html
import scala.util.DynamicVariable
import play.api.mvc.{RequestHeader, Call}

object menu {
  private val currStack = new DynamicVariable(Seq[Tag]())
  private val activeStack = new DynamicVariable(Seq[Tag]())

  sealed class Tag

  def list(name: String, call: Call)(f: => Html)(implicit req: RequestHeader): Html = {
    val tag = new Tag
    currStack.withValue(tag +: currStack.value) {
      item(name, call, Some(tag), Some(menuList(f, root = false)))
    }
  }

  def item(name: String, call: Call, tag: Option[Tag] = None, suffix: Option[Html] = None)(implicit req: RequestHeader): Html = {
    val current = req.path == call.url
    if (current)
      activeStack.value = currStack.value

    val childActive: Boolean = tag.exists(activeStack.value.contains(_))

    val active = current || childActive
    menuItem(name, call, active, current, suffix)
  }

  def apply(f: => Html): Html = {
    val result = f
    activeStack.value = Seq()
    menuList(result, root = true)
  }
}
