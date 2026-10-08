package org.cscie88c.core.week5

import scala.math

object FunctionUtils {

  case class CustomerTransaction(customerId: String,transactionDate: String,transactionAmount: Double)

  // Problem 1
  def colorToCode(color: String): (Int, Int, Int) =
    color.toLowerCase match {
      case "black"  => (0, 0, 0)
      case "white"  => (255, 255, 255)
      case "red"    => (255, 0, 0)
      case "lime"   => (0, 255, 0)
      case "blue"   => (0, 0, 255)
      case "yellow" => (255, 255, 0)
      case _        => (255, 255, 255)
    }

  def fizzBuzzString(n: Int): String =
    n match {
      case x if x % 15 == 0 => "FizzBuzz"
      case x if x % 3 == 0  => "Fizz"
      case x if x % 5 == 0  => "Buzz"
      case x                => x.toString
    }

  def fizzBuzz(n: Int): List[String] =
    (1 to n).map(fizzBuzzString).toList


  // Problem 2
  def tanDegrees: PartialFunction[Double, Double] = {
    case degrees if degrees != 90.0 && degrees != -90.0 =>
      math.tan(math.toRadians(degrees))
  }

  def totalHighValueTransactions(
    transactionList: List[CustomerTransaction]
  ): Double =
    transactionList.collect {
      case transaction if transaction.transactionAmount > 100.0 =>
        transaction.transactionAmount
    }.sum


  // Problem 3
  def flip2[A, B, C](f: (A, B) => C): (B, A) => C =
    (b: B, a: A) => f(a, b)

  def sampleList[A](items: List[A]): List[A] =
    items.take(5)

  // Write a generic function sampleList parameterized by type A, that returns the first 5 elements of a list of type A.
  
}
