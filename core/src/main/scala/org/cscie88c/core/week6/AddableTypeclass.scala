package org.cscie88c.core.week6

// Write a generic trait AddableTypeclass parameterized by type A 
trait AddableTypeclass[A] {
  def addTwoValues(a: A, b: A): A
  def getZeroValue(): A
}

object AddableTypeclass {
  implicit val intAddableTypeclass: AddableTypeclass[Int] =
    new AddableTypeclass[Int] {
      def addTwoValues(a: Int, b: Int): Int = a + b
      def getZeroValue(): Int = 0
    }

  implicit val boolAddableTypeclass: AddableTypeclass[Boolean] =
    new AddableTypeclass[Boolean] {
      def addTwoValues(a: Boolean, b: Boolean): Boolean = a || b
      def getZeroValue(): Boolean = false
    }
}

object AddableAggregator {
  def sumWithAddable[A](list: List[A])(implicit addable: AddableTypeclass[A]): A =
    list.foldLeft(addable.getZeroValue())(addable.addTwoValues)
}
 