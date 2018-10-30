import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpec}

class RouterSpec extends WordSpec with Matchers with ScalatestRouteTest {

  "A Router" should {
    "list all tutorials" in {
      Get("/tutorials") ~> Router.route ~> check {
        status shouldBe StatusCodes.OK
        responseAs[String] shouldBe "all tutorials"
      }
    }

    "return a single tutorial by id" in {
      Get("/tutorials/hello-world") ~> Router.route ~> check {
        status shouldBe StatusCodes.OK
        responseAs[String] shouldBe "tutorial hello-world"
      }
    }

    "list all comments of a given tutorial" in {
      Get("/tutorials/hello-world/comments") ~> Router.route ~> check {
        status shouldBe StatusCodes.OK
        responseAs[String] shouldBe "comments for the hello-world tutorial"
      }
    }

    "add comments to a tutorial" in {
      Post("/tutorials/hello-world/comments", "new comment") ~> Router.route ~> check {
        status shouldBe StatusCodes.OK
        responseAs[String] shouldBe "added the comment 'new comment' to the hello-world tutorial"
      }
    }
  }
}
