package org.cscie88c.core.week4

object ListUtils {
  // complete the function below
  def initDoubleList(initValue: Double)(size: Int): List[Double] = 
    List.fill(size)(initValue)

  // complete the functions below using currying
  def ones: Int => List[Double] = initDoubleList(1.0)
  def zeros: Int => List[Double] = initDoubleList(0.0)

  // complete the functions below

  def charCounts(sentence: String): Map[Char, Int] =
  sentence.toList.groupBy(identity).view.mapValues(_.size).toMap

  def topN(n: Int)(frequencies: Map[Char, Int]): Map[Char, Int] =
  frequencies.toList.sortBy { case (char, count) => (-count, char) }
    .take(n)
    .toMap
}    

