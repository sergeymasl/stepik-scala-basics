package playground
import scala.annotation.tailrec
import scala.language.postfixOps
object ScalaPlayground extends App {

  object A {
    val a: String = "value a"
    println("object A")
  }

  val aVal = A
  val anotherVal = A
}