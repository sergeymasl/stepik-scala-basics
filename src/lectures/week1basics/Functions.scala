package lectures.week1basics

object Functions extends App{

  //====================================объявление функции==========================================

  def aPerson(name: String, surname: String) : String = {
    s"$name $surname" // подстановка параметров в строку
  }
  // def - ключевое слово
  // aPerson - название функции
  // (name: String, surname: String) - параметры функции с указаниями типов данных
  // : String - тип возвращяемых данных
  // = {} - тело функции

  //=====================================инструкции в функции=======================================

  //полне возможно прописать print в теле самой функции, просто для этого необходимо изменить тип возвращаемого значения на Unit

  def aPersonUnit(name: String, surname: String): Unit = println(s"$name $surname")

  aPersonUnit("first", "second")


  //=====================================функция без параметров=======================================

  def aFunctionWithoutParameters() : Unit = println("There are no parameters in this func")

  // вызвать функцию без параметров можно двумя способами
  aFunctionWithoutParameters() // со скобками
  aFunctionWithoutParameters()   // и без них (уже нет)

  //=====================================параметры по умолчанию=======================================

  def aFunctionWithDefaultParameter(x: Int, y: String = "Default Parameter"): String = {
    s"x = $x and y = $y"
  }

  println(aFunctionWithDefaultParameter(1)) // выводит x = 1 and y = Default Parameter

  //=============================вызов_по_имени и вызов_по_значению===================================
  def callByValue(x: Long): Unit = {
    println(s"call by value: x1 = $x")
    println(s"call by value: x2 = $x")
  }

  def callByName(x: => Long): Unit = {
    println(s"call by name: x1 = $x")
    println(s"call by name: x2 = $x")
  }

  callByValue(System.nanoTime()) // подразумевает вычисление значения переданного выражения перед вызовом функции
  //                                Преимущество: значение вычисляется только один раз
  callByName(System.nanoTime())  // подразумевает вычисление значения выражения в момент его вызова в функции
  //                                Преимущество: значение не вычисляется, если не используется в теле функции


  // например
  def someFunc(): Int = 2 * someFunc() + 1 // бесконечная рекурсия
  def callSomeFunc(x: Int, y: => Int) = println(x) // здесь не используется параметр y, а т.к. он вызван по
  //                                                        имени он не будет вычеслин

  callSomeFunc(1, someFunc())

  //====================================вложенные функции=====================================

  // внутри функции можно объявлять и использовать другие функции
  def aBossFunction(): String = {
    def aHelperFunction(): String = "I'm here to help"

    aHelperFunction()
  }

  println(aBossFunction()) // выводит "I'm here to help"

}
