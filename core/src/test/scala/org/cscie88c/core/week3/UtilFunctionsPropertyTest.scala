package org.cscie88c.core.week3

import org.cscie88c.core.testutils.StandardTest
import org.scalacheck.Gen
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class UtilFunctionsPropertyTest
    extends StandardTest
    with ScalaCheckPropertyChecks {

  import UtilFunctions._

  "mult2" should {
    "satisfy the distributive property" in {
      forAll { (a: Int, b: Int, c: Int) =>
        assert(mult2(a, b + c) == mult2(a, b) + mult2(a, c))
      }
    }
  }

  "pythTest" should {
    "remain true when x and y are swapped" in {
      val triplesGen: Gen[(Int, Int, Int)] =
        Gen.oneOf(pythTriplesUpto100)

      forAll(triplesGen) { case (x, y, z) =>
        assert(pythTest(y, x, z))
      }
    }
  }
}
