import akka.http.scaladsl.server.{Directives, Route}

object Router extends Directives {

  def route: Route = path("tutorials") {
    get {
      complete("all tutorials")
    }
  }
}
