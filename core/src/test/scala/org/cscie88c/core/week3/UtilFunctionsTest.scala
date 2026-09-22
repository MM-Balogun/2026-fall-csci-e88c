package org.cscie88c.core.week3

import org.cscie88c.core.testutils.StandardTest
import org.cscie88c.core.week3.UtilFunctions._

class UtilFunctionsTest extends StandardTest {
  "UtilFunctions" when {
    "with pythTriplesUpto100" should {
      "verify elements in list are pythagorean triples" in {
        val pythTriplesTest = pythTriplesUpto100.take(3)

        assert(pythTriplesTest.size == 3)

        pythTriplesTest.foreach { case (x, y, z) =>
          assert(pythTest(x, y, z))
        }
      }
    }
  }
}
