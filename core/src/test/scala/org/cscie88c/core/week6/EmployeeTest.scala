package org.cscie88c.core.week6

import org.cscie88c.core.testutils.{ StandardTest }

class EmployeeTest extends StandardTest {
  "Employee" should {
 
    "have a default sort order" in {
      // write unit tests here
      val employees = List(
        Employee("Zoe", 25, 100),
        Employee("Amy", 30, 300),
        Employee("Bob", 40, 200)
      )
      assert(Employee.defaultSortEmployees(employees).map(_.name) ==
        List("Amy", "Bob", "Zoe"))
    }

    "sort employees by salary" in {
      // write unit tests here
      val employees = List(
        Employee("Zoe", 25, 100),
        Employee("Amy", 30, 300),
        Employee("Bob", 40, 200)
      )
      assert(Employee.sortEmployeesBySalary(employees).map(_.name) ==
        List("Amy", "Bob","Zoe"))
    }   
  }
}
