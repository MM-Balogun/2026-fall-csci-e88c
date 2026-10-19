package org.cscie88c.core.week6

import org.cscie88c.core.testutils.{ StandardTest }

class AddableTypeclassTest extends StandardTest {
  
  "AddableAggregator" should {
    "sum a list of integers" in {
      // add your unit tests here
      assert(AddableAggregator.sumWithAddable(List(1, 2, 3)) == 6)
      assert(AddableAggregator.sumWithAddable(List.empty[Int]) == 0)

    }
    "sum a list of booleans" in {
      // add your unit tests here
      assert(AddableAggregator.sumWithAddable(List(false, true, false)))
      assert(!AddableAggregator.sumWithAddable(List.empty[Boolean]))

    }
    "sum a list of employees" in {
      // add your unit tests here
      val employees = List(
        Employee("Zoe", 25, 100),
        Employee("Amy", 30, 300),
        Employee("Bob", 40, 200)
      )
      val result = AddableAggregator.sumWithAddable(employees.map(_.salary))
      assert(result == 600)
    }
  }
}
