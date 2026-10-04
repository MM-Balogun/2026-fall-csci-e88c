package org.cscie88c.core.week4

object TrigUtils {

  // https://www.scala-lang.org/api/2.13.16/scala/math/index.html
  // use the function literal syntax for sin and cos
  val sinDegrees: Double => Double = 
    degrees => math.sin(math.toRadians(degrees))
  val cosDegrees: Double => Double = 
     degrees => math.cos(math.toRadians(degrees))

  // use the placeholder syntax for squared
  val squared: Double => Double = 
    math.pow(_, 2.0)
  
}
