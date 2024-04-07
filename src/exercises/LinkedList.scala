package exercises

import sun.invoke.empty.Empty

object LinkedList extends App{
  abstract class LogList[+A]{
    def add[B >: A](msg : String) : LogList[B]
    def last : String
    // проверяем пустой ли список
    def isEmpty : Boolean = this == Empty
    def previous : LogList
    def all : String
  }
  object Empty extends LogList{
    def add(msg : String) : LogList = new Log(msg, Empty)
    def last = throw new NoSuchElementException("NoSuchElementException")
    def previous = throw new NoSuchElementException("NoSuchElementException")
    def all : String = ""
  }
  class Log(head : String, tail:LogList) extends LogList{
    // добавляем новый элемент в список
    def add(msg : String) : LogList = new Log(msg, this)
    // выводим последний ДОБАВЛЕННЫЙ элемент (то есть head списка)
    def last : String = head
    // вывод previus
    def previous : LogList = tail
    def all : String = {
      def loop(acc : String, current : LogList) : String = {
        if (current.isEmpty) acc
        else loop(acc ++ " " ++ current.last, current.previous)
      }
      loop("", this).substring(1)
    }
  }

  val her = new Log("1", Log("2", Log("3", Empty)))
  println(her.add("4").all)


}


