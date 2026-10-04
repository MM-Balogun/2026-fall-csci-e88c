package org.cscie88c.core.week4

object FunctionUtils {
  
  // complete the implementation of the higher order functions below
  def applyNTimes(n: Int)(x: Int)(f: Int => Int): Int = 
    (0 until n).foldLeft(x)((result,_) => f(result))

  def myPositivePower(x: Int, n: Int): Int = 
    applyNTimes(n)(1)(result => result * x)


  def deferredExecutor(name: String)(f: Int => Int): Int => Int = 
    (input: Int) => {
      println(s"running on deffered executor $name with value $input")
      f(input)
    }
}