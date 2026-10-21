package org.cscie88c.core.week7

import org.cscie88c.core.testutils.{ StandardTest }
import scala.util.{Try, Success, Failure}

class CustomerTransactionTest extends StandardTest {
  "CustomerTransaction" should {
    "load and clean raw CSV data file" in {
      // add unit tests below
      assert(
      CustomerTransaction("T1,C1,12.50") ==
        Some(CustomerTransaction("T1", "C1", 12.50))
      )
    }

    "reject an invalid amount" in {
      assert(CustomerTransaction("T1,C1,not-a-number") == None)
    }

    "reject a row with missing fields" in {
      assert(CustomerTransaction("T1,C1") == None)
    }
  }
    "readFromCSVFile" should {
      "read five valid customer records" in {
         val records =
           CustomerTransaction.readFromCSVFile("data/dirty-retail-data-sample.csv")

         assert(records.size == 5)
      }
    }
}
