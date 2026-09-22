package org.cscie88c.beam

import com.spotify.scio._
import com.twitter.algebird._
// import com.twitter.algebird._

import com.twitter.algebird.Operators._
// import com.twitter.algebird.Operators._


// res0: scala.collection.immutable.Map[Int,com.twitter.algebird.Max[Int]] = Map(2 -> Max(4), 1 -> Max(3))
// Beam word count example
// run locally using
// sbt beam/run
object BeamJob {
  def main(args: Array[String]): Unit = {
    val (sc: ScioContext, jobArgs: Args) = ContextAndArgs(args)
    implicit val scImplicit: ScioContext = sc
    val inputFile =
      jobArgs.getOrElse("input-file", "../data/alice_in_wonderland.txt")
    val outputFile =
      jobArgs.getOrElse("output-file", "./target/alice_word_count")
    // Define the pipeline

    val wordCounts = sc
      .textFile(inputFile)
      .flatMap(_.split("\\W+"))
      .map(_.toLowerCase)
      .countByValue

    // Write the output
    wordCounts.saveAsTextFile(outputFile)
    sc.run().waitUntilDone()
  }
}
