package org.cscie88c.core.week6

final case class Employee(name: String, age: Int, salary: Int)

object Employee {
  implicit val employeeOrdering: Ordering[Employee] =
    Ordering.by[Employee, String](_.name)

  def defaultSortEmployees(employees: List[Employee]): List[Employee] =
    employees.sorted

  def sortEmployeesBySalary(employees: List[Employee]): List[Employee] =
    employees.sorted(Ordering.by[Employee, Int](_.salary).reverse)
  //Bonus
  Employee("Zoe,Amy,Bob", 95, 600)  

  implicit val employeeAddable: AddableTypeclass[Employee] =
  new AddableTypeclass[Employee] {
    def addTwoValues(a: Employee, b: Employee): Employee =
      Employee(
        List(a.name, b.name).filter(_.nonEmpty).mkString(","),
        a.age + b.age,
        a.salary + b.salary
      )

    def getZeroValue(): Employee = Employee("", 0, 0)
  }
}




