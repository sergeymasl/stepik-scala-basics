package lectures.week1basics

import scala.+:
import scala.io.StdIn

object StringOperations extends App {

  //===============================методы работы со строками========================================

  // объявляем переменную
  val aString : String = "Hello, world!"

  println(aString)

  // методы


  println(aString.length) // длинна строки // выведет 13
  println(aString.charAt(1)) // выводит символ с индексом в скобках // индексация начинается с 0
  println(aString.substring(0, 2)) // срез строки // выведет He // символ с вторым индексом не выводится
  println(aString.split(" ").toList) // деление по разделителю // метод toList преобразует объект Java в спикок
  println(aString.startsWith("He")) // проверяет начинается ли строка с символов в скобках // выведет True
  println(aString.replace("!", ".")) // замена символов
  println(aString.toLowerCase) // в нижний регистр
  println(aString.toUpperCase) // в верхний регистр
  println("abcd".reverse) // переворачивает строку // выведет dcba
  println("abcd".take(3)) // обирает n количество первых символов

  //============================================input==================================================
  // https://scala-lang.org/api/current/scala/io/StdIn%24.html
  val test_input = scala.io.StdIn.readLine()
  // readBoolean() : Boolean
  // readByte() : Byte
  // readChar() : Char
  // readDouble() : Double
  // readFloat() : Float
  // readInt() : Int
  // readLine() : String
  // readLong() : Long
  // readShort() : Short
  // something other ...

  //===========================добавление char в начало или конец string===============================


  println('1' +: "42" :+ '3') // выводит 1423
  println('a' +: "bc" :+ 'd') // abcd
  println("a" ++: "bc" :++ "d") // abcd
  println("a" ++ "bc" + "d")

  // если Char добавляется в начало String, то используется +:
  // если Char добавляется в конец String, то используется :+
  // ТО ЕСТЬ двоеточие в данном случае означает где находится String

  // если String добавляется в начало другой String, используется ++:
  // если String добавляется в конец другой String, используется :++

  // операторы ++ и + работают со String и присоединяют все это (разница в производительности)


  //========================интерполяция строк (подстановка переменных)===============================
  //интерполяция применяется когда в строку необходимо подставить какое-то значение переменной

  //     1. s-интерполятор

  val test_var_1 : String = "test"
  println(s"let's to do $test_var_1 and $test_var_1") // выводит let's to do test and test

  // если необходимо вставить выражение (код) то используются фигурные скобки
  println(s"let's to do ${test_var_1.toUpperCase}") // выводит let's to do TEST

  //     2. raw-интерполятор
  // raw интерполятор экранирует все спецсимволы в шаблоне строки,
  // но не трогает спецсимволы в выражении или подставляемой переменной


}
