package org.cscie88.core.week7

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Random, Success}
import scala.collection.parallel.CollectionConverters._

object FutureUtils {
  val rnd = new Random()

  def creditScoreAPI(applicantId: Int): Future[Int] = Future {
    if (rnd.nextInt(5) == 0)
      throw new RuntimeException("credit score lookup failed")

    300 + rnd.nextInt(501) 
  }

  def printCreditScore(applicantId: Int): Unit = {
    creditScoreAPI(applicantId).onComplete {
      case Success(score) =>
        println(s"Applicant $applicantId credit score: $score")
      case Failure(error) =>
        println(s"Applicant $applicantId credit score failed: ${error.getMessage}")
    }
  }

  def passedCreditCheck(applicantId: Int): Future[(Int, Boolean)] =
    creditScoreAPI(applicantId).map { score =>
      (applicantId, score >= 650)
    }

  def futureFactorial(n: Int): Future[Int] = Future {
    require(n >= 0, "n must be nonnegative")
    (1 to n).product
  }

  def futurePermutations(n: Int, r: Int): Future[Int] = Future {
    require(n >= 0 && r >= 0 && r <= n, "require 0 <= r <= n")
    (n - r + 1 to n).product
  }

  def asyncAverageCreditScore(idList: List[Int]): Future[Double] = {
    require(idList.nonEmpty, "idList must not be empty")

    Future.traverse(idList)(creditScoreAPI).map { scores =>
      scores.map(_.toDouble).sum / scores.size
    }
  }

  def slowMultiplication(x: Long, y: Long): Long = {
    Thread.sleep(100)
    x * y
  }

  def concurrentFactorial(n: Long): Long = {
    require(n >= 0 && n <= Int.MaxValue, "n must be a nonnegative Int-sized value")
    (1L to n).par.map(x => slowMultiplication(x, 1L)).product
  }

  def sequentialFactorial(n: Long): Long = {
    require(n >= 0 && n <= Int.MaxValue, "n must be a nonnegative Int-sized value")
    (1L to n).map(x => slowMultiplication(x, 1L)).product
  }
}
