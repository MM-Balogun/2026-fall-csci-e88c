package org.cscie88c.core.week4

import org.cscie88c.core.testutils.{StandardTest}
import TrigUtils.{sinDegrees, cosDegrees}

class TrigUtilsTest extends StandardTest {
  
  "TrigUtils" when {
    "calling sin" should {
      "return the correct value for 90" in {
        // write unit test below
        val tolerance = 1e-10
        assert(math.abs(sinDegrees(0) - 0.0) < tolerance)
        assert(math.abs(sinDegrees(90) - 1.0) < tolerance)
        assert(math.abs(cosDegrees(0) - 1.0) < tolerance)
        assert(math.abs(cosDegrees(90) - 0.0) < tolerance)
       

      }
    
    }

    // write tests for cos and squared below
    "calling squared" should {
      "return the square" in {
        "assert(squared(3.0) == 9.0)" 
      }    
    }
     
  }
}
