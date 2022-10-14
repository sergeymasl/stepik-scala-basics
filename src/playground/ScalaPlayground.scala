package playground
import scala.annotation.tailrec
import scala.language.postfixOps
object ScalaPlayground extends App {
  class Person(val name: String, occupation: String) {
    def worksAs(jobName: String): String = s"$name is a $jobName"

    def isDeveloper = worksAs "Scala Developer"
  }

  val bob = new Person("Bob", "Developer")
  println(bob isDeveloper)
}