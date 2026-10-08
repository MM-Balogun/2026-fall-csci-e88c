package org.cscie88c.core.week5

import org.cscie88c.core.testutils.{ StandardTest }
import FunctionUtils.CustomerTransaction

// run using: sbt "testOnly org.cscie88c.week5.FunctionUtilsTest"
class FunctionUtilsTest extends StandardTest {
  "FunctionUtils" when {
    // Problem 1 unit tests
    "calling colorToCode" should {
      "return the correct value for white" in {
        assert(FunctionUtils.colorToCode("White") == (255, 255, 255))
        assert(FunctionUtils.colorToCode("lime") == (0, 255, 0))
        assert(FunctionUtils.colorToCode("unknown") == (255, 255, 255))
      }
    }
    
    "calling fizzBuzzString" should {
      "return the correct value" in {
        assert(FunctionUtils.fizzBuzzString(1) == "1")
        assert(FunctionUtils.fizzBuzzString(3) == "Fizz")
        assert(FunctionUtils.fizzBuzzString(5) == "Buzz")
        assert(FunctionUtils.fizzBuzzString(15) == "FizzBuzz")
      }
    }

    "calling fizzBuzz" should {
      "return the correct value" in {
        assert(
          FunctionUtils.fizzBuzz(15) ==
            List("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8",
              "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz")
        )
      }
    } 

    
    // Problem 2 unit tests
    "calling tanDegrees" should {
      "be defined except at positive and negative 90 degrees" in {
        val tan = FunctionUtils.tanDegrees

        assert(tan.isDefinedAt(0.0))
        assert(tan.isDefinedAt(45.0))
        assert(!tan.isDefinedAt(90.0))
        assert(!tan.isDefinedAt(-90.0))
        assert(math.abs(tan(0.0)) < 1e-10)
        assert(math.abs(tan(45.0) - 1.0) < 1e-10)
      }
    }

    "calling totalHighValueTransactions" should {
      "sum only transaction amounts greater than 100" in {
       val transactions = List(
        CustomerTransaction("A", "2024-01-01", 50.0),
        CustomerTransaction("B", "2024-01-02", 100.0),
        CustomerTransaction("C", "2024-01-03", 150.0),
        CustomerTransaction("D", "2024-01-04", 200.0)
       )

       assert(FunctionUtils.totalHighValueTransactions(transactions) == 350.0)
       assert(FunctionUtils.totalHighValueTransactions(Nil) == 0.0)
      }
    }
 
    // Problem 3 unit tests
    "calling flip2" should {
      "reverse the arguments of a two-argument function" in {
        val subtract: (Int, Int) => Int = (a, b) => a - b
        val flipped = FunctionUtils.flip2(subtract)

        assert(flipped(3, 10) == 7)
      }
    }

    "calling sampleList" should {
      "return at most the first five elements" in {
        assert(FunctionUtils.sampleList(List(1, 2, 3, 4, 5, 6)) ==
          List(1, 2, 3, 4, 5))
        assert(FunctionUtils.sampleList(List("a", "b")) ==
          List("a", "b"))
        assert(FunctionUtils.sampleList(List.empty[Int]) == Nil)
      }
    }
   
    // Bonus unit tests
  }

}
