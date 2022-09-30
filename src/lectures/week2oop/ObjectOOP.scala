package lectures.week2oop

object ObjectOOP extends App{
  //====================================Объекты================================================
  // создание объекта напоминает создание класса, только с ключевым словом object
  // переменные и методы созданные в объекте будут доступны в любое время в любом месте
  // без дополнительного объявления экземпляров класса
  // (как я понял это способ группировки переменных и методов)


  object Number{
    val Pi = 3.14
  }
  println(Number.Pi)

  //===========================отличительные черты объектов=====================================
  // отличительной чертой объектов является то, что они:
  //     НЕ ИМЕЮТ параметров
  //     ЯВЛЯЮТСЯ одиночками
  // то есть при присваивании разным переменным одного объекта означает, что они ссылаются на один и тот же объект
  // а при объявлении новых ЭКЗЕМПЛЯРОВ класса, всегда будет новый экземпляр
  // например

  object TestObj
  val aObj = TestObj
  val bObj = TestObj

  println(aObj == bObj) // выдаст true


  class TestClass
  val aClass = new TestClass
  val bClass = new TestClass

  println(aClass == bClass) // выдаст false


  //========================================компаньоны=====================================
  // если в одном и том же файле объявить ОБЪЕКТ и КЛАСС с одним и тем же именем, то их можно назвать КОМПАНЬОНАМИ
  // ОБЪЕКТ в таком случае имеет доступ ко всем полям и методам своего класса-компаньона (даже к private)

  class MyString(val someString: String) {
    private var extra : String = "extraData"
    def getString : String = someString ++ extra
  }

  object MyString { // назван так же как и класс
    def apply(base : String, extras : String) : MyString = {
      val s = new MyString(base)
      s.extra = extras // доступ к private val класса MyString, её изменение
      s
    }
    def apply(base : String) = new MyString(base)
  }

  println(MyString.apply("hello", "world").getString) // пойдет через apply со сменой val extra на "world"
  println(MyString.apply("welcome ").getString) // пойдет через apply без смены val extra

  // ===================================фабричный метод=====================================
  // хрен его знает зачем это нужно, может быть для усложненного создания класса
  // например если одно значение, то этот класс. Если другое, то другой класс
  // вот один из примеров: (хрен его знает зачем)

  class NumberV(val num: Int)

  object NumberV {
    val Pi = 3.14

    def apply(x: NumberV, y: NumberV): NumberV = new NumberV(x.num + y.num)
  }

  val numA = new NumberV(1)
  val numB = new NumberV(2)

  val numC = NumberV(numA, numB) // применяем apply

  println(numA.num) // 1
  println(numB.num) // 2
  println(numC.num) // 3

}

