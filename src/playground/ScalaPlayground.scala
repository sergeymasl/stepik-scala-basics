package playground

object ScalaPlayground extends App{
  import scala.annotation.tailrec

  def sumAndPrintInt(x : Int, y : Int, n : Int) : Unit = {
    @tailrec
    // функция для добавления чисел
    def loop_sum(x : Int = x, y : Int = y, n : Int = n) : Int = {
      if(n < 1) x
      else loop_sum(x = x + y, n = n - 1)
    }

    @tailrec
    // функция по подстчету количества разрядов
    // здесь НЕТ ЦЕЛОЧИСЛЕННОГО деления
    // а при делении Int на Int ВСЕГДА будет INT
    def loop_count(n: Int, sign: Int = 10, count : Int = 1): Int = {
      if ((n / sign) == 0) count
      else loop_count(n, sign * 10, count + 1)
    }

    println(s"${loop_sum()} " * loop_count(loop_sum()) ++ "is the result")
  }

  sumAndPrintInt(10, 1, 5)
}
