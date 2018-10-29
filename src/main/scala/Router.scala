import akka.http.scaladsl.server.{Directives, Route}

object Router extends Directives {

  def route: Route = pathPrefix("tutorials") {
    pathEnd {
      get {
        complete("all tutorials")
      }
    } ~ path(Segment) { id =>
      get {
        complete(s"tutorial $id")
      }
    }
  }
}
