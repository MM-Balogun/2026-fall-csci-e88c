package org.cscie88c.core.week5

import java.util.UUID
import scala.util.Random

object Streams {
  val rnd = new Random()
  def uuid: String = UUID.randomUUID.toString.replaceAll("-", "")

  case class Dog(name: String, age: Int, hasCurrentShots: Boolean)

  val mult5: LazyList[Int] =
  LazyList.from(0, 5).takeWhile(_ <= 100)

  val randIntStream: LazyList[Int] =
    LazyList.continually(rnd.nextInt(16))

  val dogs: LazyList[Dog] =
    LazyList.continually {
      Dog(s"dog-$uuid", rnd.nextInt(16), rnd.nextBoolean())
    }

  def healthyDogs(dogs: LazyList[Dog]): LazyList[Dog] =
    dogs.filter(_.hasCurrentShots)

  def averageHealthyAge(allDogs: LazyList[Dog], sampleSize: Int): Double = {
    val healthy = healthyDogs(allDogs.take(sampleSize)).toList
    if (healthy.isEmpty) 0.0
    else healthy.map(_.age.toDouble).sum / healthy.size
  }
}
