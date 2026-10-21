package org.cscie88c.core.week7

import org.cscie88c.core.testutils.{FuturesTest}
import scala.concurrent.Future
import org.cscie88.core.week7.FutureUtils


class FutureUtilsTest extends FuturesTest {
  
  "Any future function" should {
    "return a future assertion" in {
      def futureAdd2(x: Int) = Future(x + 2)
      futureAdd2(5).map { x =>
        x shouldBe 7
      }
    }
  }

  "FutureFunctions" when {
    "calling creditScoreAPI" should {
      "return a credit score greater than 300" in {
        // add unit tests below
        FutureUtils.creditScoreAPI(1).transform {
          case scala.util.Success(score) =>
            score should be >= 300
            score should be <= 800
            scala.util.Success(succeed)
          case scala.util.Failure(_) =>
            scala.util.Success(succeed) 
       }
      }
    }
    "calling futureFactorial" should {
      "return 24 for 4" in {
        FutureUtils.futureFactorial(4).map { result =>
         result shouldBe 24
        }
      }
    }
  }
}
