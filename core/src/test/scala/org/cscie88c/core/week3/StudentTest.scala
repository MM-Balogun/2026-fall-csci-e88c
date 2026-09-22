package org.cscie88c.core.week3

import org.cscie88c.core.testutils.{StandardTest}

class StudentTest extends StandardTest {
  "Student Management System" when {
    "creating a student" should {
      "have properties - name, email, subject and score" in {
        // write your test here
        val student = Student(
          name = "Ada Lovelace",
          email = "ada@example.com",
          subject = "Math",
          score = 95
        )
        assert(student.name == "Ada Lovelace")
        assert(student.email == "ada@example.com")
        assert(student.subject == "Math")
        assert(student.score == 95)
      }
    }
    
  }

}
