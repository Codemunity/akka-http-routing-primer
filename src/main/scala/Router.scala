import akka.http.scaladsl.server.{Directives, Route}

object Router extends Directives {

  def route: Route = pathPrefix("tutorials") {
    pathEnd {
      get {
        complete("all tutorials")
      }
    } ~ pathPrefix(Segment) { id =>
      pathEnd {
        get {
          complete(s"tutorial $id")
        }
      } ~ path("comments") {
        get {
          complete(s"comments for the $id tutorial")
        }
      }
    }
  }
}
