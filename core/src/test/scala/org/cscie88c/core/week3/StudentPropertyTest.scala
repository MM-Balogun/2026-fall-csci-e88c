package org.cscie88c.core.week3

import org.scalacheck.Gen
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.cscie88c.core.testutils.StandardTest

class StudentPropertyTest extends StandardTest with ScalaCheckPropertyChecks {

  val nameGen: Gen[String] =
    Gen.alphaStr.suchThat(_.nonEmpty)

  val emailGen: Gen[String] =
    for {
      name <- Gen.alphaStr.suchThat(_.nonEmpty)
      domain <- Gen.alphaStr.suchThat(_.nonEmpty)
    } yield s"$name@$domain.com"

  val subjectGen: Gen[String] =
    Gen.oneOf("English", "Math", "Science")

  val scoreGen: Gen[Int] =
    Gen.choose(0, 100)

  val studentGen: Gen[Student] =
    for {
      name <- nameGen
      email <- emailGen
      subject <- subjectGen
      score <- scoreGen
    } yield Student(name, email, subject, score)

  "Student description" should {
    "contain the student's name and email" in {
      forAll(studentGen) { student =>
        student.description should include(student.name)
        student.description should include(student.email)
      }
    }
  }
  val studentListGen: Gen[List[Student]] =
  Gen.listOf(studentGen)

  "averageScoreBySubject" should {
    "be less than 100 for generated Math students with scores below 100" in {
      val mathStudentsGen =
        Gen.listOf(
          for {
            name <- nameGen
            email <- emailGen
            score <- Gen.choose(0, 99)
          } yield Student(name, email, "Math", score)
        ).suchThat(_.nonEmpty)

      forAll(mathStudentsGen) { students =>
        assert(Student.averageScoreBySubject("Math", students) < 100)
      }
    }
  }

}
// The property is that if a student has a score below 100, then the average score for the subject Math should be less than 100