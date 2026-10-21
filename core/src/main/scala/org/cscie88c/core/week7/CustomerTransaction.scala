package org.cscie88c.core.week7

import scala.io.Source
import scala.util.{Try, Success, Failure}

final case class CustomerTransaction(
  transactionId: String,
  customerId: String,
  transactionAmount: Double
)

object CustomerTransaction {
  // add companion object methods below
  def apply(csvString: String): Option[CustomerTransaction] =
    csvString.split(",", -1).toList match {
      case List(id, customer, amount) =>
        scala.util.Try(
          CustomerTransaction(id, customer, amount.toDouble)
        ).toOption
      case _ => None
    }

  def readFromCSVFile(fileName: String): List[CustomerTransaction] = {
    val source = scala.io.Source.fromResource(fileName)
    try source.getLines().flatMap(line => CustomerTransaction(line)).toList
    finally source.close()
  }
}


