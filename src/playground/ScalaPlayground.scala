package playground
import scala.annotation.tailrec
object ScalaPlayground extends App{
  class MyString(val str: String) {
    private var extra = "extraData"

    def getString: String = str + extra
  }

  object MyString {
    def apply(base: String, extras: String): MyString = {
      val s = new MyString(base)
      s.extra = extras
      s
    }

    def apply(base: String) = new MyString(base)
  }

  println(MyString.apply("hello", "world").getString)
  println(MyString.apply("welcome").getString)
}
