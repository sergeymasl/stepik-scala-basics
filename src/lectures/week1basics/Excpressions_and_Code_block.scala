package lectures.week1basics

object Excpressions_and_Code_block extends App{

  //=======================Выражения(Expressions) и Инструкции (Instructions)==================================

  /*
  val aVal : Int = 1 + 2 * 3
  println(aVal)

  // 1 + 2 * 3 - это выражение

  val test_vat = println("print it please")

  println(test_vat)
  //println(test_vat.getClass)
     */


  //=============================блоки кода=====================================

  // блок кода это все строки кода, которые мы пишем в фигурных скобках

  val aCodeBlock = {
    val someVal = 1
    val y = 2

    if (someVal + y > 1) true else false // результат этого выражения и будет результатом всего блока
  }

  println(aCodeBlock) // выведет true и тип данных boolean
  println(aCodeBlock.getClass)

  // блок кода представляет собой выражение результат которого (и тип) равен ПОСЛЕДНЕМУ описаннму в блоке выражению
  // переменные объявленные внутри блока нельзя использовать вне блока. Внутри блока можно использовать
  //                                                                    глобальные переменные

}
