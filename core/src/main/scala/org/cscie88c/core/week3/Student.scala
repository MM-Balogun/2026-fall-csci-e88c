package org.cscie88c.core.week3

final case class Student(
    name: String,
    email: String,
    subject: String,
    score: Int
) {
  def description: String =
    s"name: ${name}, email: ${email}, subject: ${subject}, score: ${score}"
}

object Student {

  def validateEmail(student: Student): Boolean =
    student.email.contains("@")

  def averageScoreBySubject(
      subject: String,
      studentList: List[Student]
  ): Double = {
    val scores = studentList
      .filter(_.subject == subject)
      .map(_.score)

    scores.sum.toDouble / scores.length
  }

  def averageScoreByStudent(
      student: Student,
      studentList: List[Student]
  ): Double = {
    val scores = studentList
      .filter(_.email == student.email)
      .map(_.score)

    scores.sum.toDouble / scores.length
  }

}
