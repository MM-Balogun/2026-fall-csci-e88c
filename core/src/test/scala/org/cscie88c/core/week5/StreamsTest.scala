package org.cscie88c.core.week5

import org.cscie88c.core.testutils.{ StandardTest }
import Streams.Dog

class StreamsTest extends StandardTest {

  // Bonus problem unit tests
  "Streams" should {
    "produce multiples of five through 100" in {
      assert(Streams.mult5.toList == (0 to 100 by 5).toList)
    }

    "produce random integers from 0 through 15" in {
      val values = Streams.randIntStream.take(100).toList
      assert(values.size == 100)
      assert(values.forall(n => n >= 0 && n <= 15))
    }

    "filter healthy dogs and average their ages within the sample" in {
      val sample = LazyList(
        Dog("A", 2, true),
        Dog("B", 4, false),
        Dog("C", 6, true),
        Dog("D", 8, false),
        Dog("E", 10, true)
      )

      assert(Streams.healthyDogs(sample).map(_.name).toList ==
        List("A", "C", "E"))
      assert(Streams.averageHealthyAge(sample, 5) == 6.0)
      assert(Streams.averageHealthyAge(sample, 2) == 2.0)
    }

    "allow a finite sample from the dog stream" in {
      assert(Streams.dogs.take(5).toList.size == 5)
    }
  }
}
