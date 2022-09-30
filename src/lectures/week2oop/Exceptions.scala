package lectures.week2oop

object Exceptions extends App{

  //===============================исключения (Exceptions) и ошибки (Errors)===================================

  //----------------Errors
  // Errors - указвают на то, что что-то не так с системой.
  // Например
  // StackOverflowError - переполнение памяти stack (?), под каждый вызов метода в стеке создается новый блок,
  //                                                     хранящий информацию о параметрах, переменных метода
  // OutOfMemoryError - точно также указывает что мы исчерпали доступную нам память, только в этот раз head (?) память

  //----------------Exceptions
  //Exceptions - указывают на то, что что-то не так с вашей(нашей) программой
  // Например
  // NullPointerException - возникает, если мы пытаемся получить доступ к чему-то, чего нет
  // RuntimeException - бросается, когда необходимо указать на какие-то логические ошибки программы

  // Для самостоятельного вызова исключения необходимо использовать ключевое слово throw (бросить)
  //                                                   , за которым должно следовать new

  //throw new RuntimeException("First Exception") // RuntimeException




  // =====================================try-catch-finally====================================================

  def intOrNothing(hasException : Boolean = false): Unit = {
    if (hasException) throw new RuntimeException("Exception is here")
    else 200
  }

  // try содержит код, который потенциально может вызвать исключение
  try {
    intOrNothing(true)
  }
    // catch - перечесление всех возможных исключений и как на них реагировать
    catch {
      case e: NullPointerException => println("NPE is here")
      case e: RuntimeException => println("RE is here")
    }
      // finally - метод который будет выполняться вне зависимости было исключение или нет
      // сюда можно засунуть закрытие файлов сохранение данных и т.д.
      finally {
        println("i will be there no matter what")
      }



  //===================================создание собственного исключения===============================
  // создаем подкласс от Exception

  class MyException extends Exception

}
