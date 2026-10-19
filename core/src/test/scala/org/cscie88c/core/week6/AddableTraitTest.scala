package org.cscie88c.core.week6

import org.cscie88c.core.testutils.{ StandardTest }

class AddableTraitTest extends StandardTest {

  "plus" should {

    "add two MyInt values correctly" in {
      // add your unit tests for MyInt below
      assert(MyInt(2).plus(MyInt(3)) == MyInt(5))
      assert(MyInt(-2).plus(MyInt(3)) == MyInt(1))
      assert(MyInt(0).plus(MyInt(4)) == MyInt(4))
    }

    "add two MyBool values correctly" in {
      // add your unit tests for MyBool below
      assert(MyBool(true).plus(MyBool(true)) == MyBool(true))
      assert(MyBool(true).plus(MyBool(false)) == MyBool(true))
      assert(MyBool(false).plus(MyBool(true)) == MyBool(true))
      assert(MyBool(false).plus(MyBool(false)) == MyBool(false))
    }
  } 
}
