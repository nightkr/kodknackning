package controllers

import play.api.mvc._

object Application extends Controller {

  def index = Action {
    implicit req =>
      Ok(views.html.index())
  }

  def about = Action {
    implicit req =>
      Ok(views.html.content.about())
  }

  def introduction = Action {
    implicit req =>
      Ok(views.html.content.introduction())
  }

  def conventions = Action {
    implicit req =>
      Ok(views.html.content.conventions())
  }

  def gettingstarted = Action {
    implicit req =>
      Ok(views.html.content.gettingstarted())
  }

  def helloWorld = Action {
    implicit req =>
      Ok(views.html.content.helloWorld())
  }

}