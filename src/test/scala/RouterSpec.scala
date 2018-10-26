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
  }
}
