package org.cscie88c.core.week4

import org.scalatest.wordspec.AnyWordSpec
import org.cscie88c.core.week4.ListUtils._

class ListUtilsTest extends AnyWordSpec {


  "ListUtils" when {

    "calling ones" should {
      "return the correct value" in {
        assert(ones(3).length == 3)
        assert(ones(3).forall(_ == 1.0))
      }
    }

    "calling zeros" should {
      "return the correct value" in {
        assert(zeros(3).length == 3)
        assert(zeros(3).forall(_ == 0.0))
      }
    }

    "charCounts" should {
      "count characters in Hello world" in {
        assert(charCounts("Hello world") == Map (
          'H' -> 1, 'e' -> 1, 'l' -> 3, 'o' -> 2,
          'w' -> 1, 'r' -> 1, 'd' -> 1, ' ' -> 1
        ))
      }

      "identify a pangram" in {
        val counts =
          charCounts("The quick brown fox jumps over the lazy dog".toLowerCase)
        assert(('a' to 'z').forall(counts.contains))
      }
    }

    "topN" should {
      "return the most frequent characters" in {
        val frequencies = Map(
          'e' -> 1, 'l' -> 3, 'H' -> 1, 'w' -> 1,
          'r' -> 1, 'o' -> 2, 'd' -> 1
        )
        assert(topN(2)(frequencies) == Map('l' -> 3, 'o' -> 2))
      }
    }
  }
}
