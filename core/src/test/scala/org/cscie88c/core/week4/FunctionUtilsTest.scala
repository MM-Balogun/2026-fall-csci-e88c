package org.cscie88c.core.week4

import org.cscie88c.core.testutils.{StandardTest}
import FunctionUtils.{applyNTimes, myPositivePower, deferredExecutor}
import TrigUtils.{sinDegrees, cosDegrees}

class FunctionUtilsTest extends StandardTest {

   "FunctionUtils" when {
    "calling applyNtimes" should {
      "return the correct value" in {
        // write unit test here
        def add5(x: Int): Int = x + 5

        assert(applyNTimes(0)(4)(add5) == 4)
        assert(applyNTimes(1)(4)(add5) == 9)
        assert(applyNTimes(3)(0)(add5) == 15)
      }
    }

    "calling myPositivePower" should {
      "compute powers" in {
        assert(myPositivePower(2, 3) == 8)
        assert(myPositivePower(5, 1) == 5)
        assert(myPositivePower(7, 0) == 1)
      }
    }

    "calling deferredExecutor" should {
      "run the function when called" in {
        def add5(x: Int): Int = x + 5

        val deferred = deferredExecutor("CPU Pool")(add5)
        assert(deferred(4) == 9)
      }
    }
  }
}

