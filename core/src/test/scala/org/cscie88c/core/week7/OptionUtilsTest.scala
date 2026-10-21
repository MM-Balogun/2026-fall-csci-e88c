package org.cscie88c.core.week7

import org.cscie88c.core.testutils.{ StandardTest }
import scala.util.{Try, Success, Failure}

class OptionUtilsTest extends StandardTest {
  "OptionUtils" when {
    "calling fileCharCount" should {
      "return the correct number of characters in a valid file" in {
        // add unit tests below
        val result = OptionUtils.fileCharCount("data/dirty-retail-data-sample.csv")
        assert(result == Success(195L))
      }
    }  
    "calling charCountAsString" should {
      "describe the count for a valid file" in {
        assert(
          OptionUtils.charCountAsString("data/dirty-retail-data-sample.csv") ==
            "number of characters: 195"
        )
      }

      "report an error for a missing file" in {
        assert(
          OptionUtils.charCountAsString("data/dirty-retail-data-sample.csv-x") ==
            "error opening file"
        )
      }
    }
  }
}
