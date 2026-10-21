package org.cscie88c.core.week7

import scala.io.Source
import scala.util.{Try, Success, Failure}

object OptionUtils {
  
  def fileCharCount(fileName: String): Try[Long] =
  Try {
    val source = Source.fromResource(fileName)
    try source.mkString.length.toLong
    finally source.close()
  }

def charCountAsString(fileName: String): String =
  fileCharCount(fileName) match {
    case Success(count) => s"number of characters: $count"
    case Failure(_)     => "error opening file"
  }

  def lineStreamFromFile(fileName: String): Option[LazyList[String]] =
  Try(Source.fromResource(fileName)).toOption.map { source =>
    val iterator = source.getLines()

    def lines: LazyList[String] =
      if (iterator.hasNext) iterator.next() #:: lines
      else {
        source.close()
        LazyList.empty
      }

    lines
  }
}