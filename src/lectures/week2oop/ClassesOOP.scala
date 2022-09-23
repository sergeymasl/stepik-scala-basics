package lectures.week2oop

object ClassesOOP extends App {

  //============================================КЛАССЫ====================================================

  //=========================================общая информация=============================================
  // объявление (создание) класса
  class Student

  // создание экземпляра класса происходит при наличии ключевого слова new
  val student = new Student

  //==========================================атрибуты класса=============================================
  // атрибуты класса могут быть приватными и не приватными
  // приватные атрибуты можно использовать только внутри класса и к ним нельзя получить доступ извне
  // чтобы получить возможность доступа через точку нужно добавить ключевое слово val или var
  // такие переменные переходят из ПАРАМЕТРА КОНСТРУКТА в ПОЛЕ КЛАССА

  class SomeClass(id : Int, val name: String)

  val SomeTest = new SomeClass(id = 0, name = "TestName")

  println(SomeTest.name)

  //==========================================тело класса=============================================
  // тело класса описывается в фигурных скобках как и блоки кода БЕЗ равно
  // при создании ЭКЗЕМПЛЯРА класса выполняется все что прописано в теле класса
  // ко всему что прописывается в теле класса можно получить доступ через точку
  // в теле класса можно прописать private val/var и его нельзя получить через точку

  class SomeClassA(id: Int, name: String) {
    val uni: String = "VLSU"
    private val pri_uni : String = "VAMK"
  }
  val someTestA = new SomeClassA(1, "Erik")
  println(someTestA.uni)

  //=================================ключевое слово this в методе класса===============================
  // ключевое слово this в методах позволяет вызывать поле классов
  // аналог self в python

  class SomeClassB(id: Int, name: String) {
    def SomeFunc(name: String) : String = {
      s"area of class name ${this.name}, area of method name $name"
    }
  }

  val someTestB: SomeClassB = new SomeClassB(2, "Max")
  println(someTestB.SomeFunc("Erikk"))

  //================================перегрузка метода (Overloading)====================================
  // класс может иметь функции с одинаковым названием
  // Единственное условие - чтобы набор аргументов и(или) их тип были разнвми чтобы компилятор мог понять
  // вызов какой именно функции вам требуется

  class SomeClassD(id: Int, name: String) {
    def SomeFunc(name: String) : String = {
      s"area of class name ${this.name}, area of method name $name"
    }
    def SomeFunc : String = s"area of class name $name"
  }

  val someTestD : SomeClassD = new SomeClassD(5, "Grog")
  println(someTestD.SomeFunc("Vax"))
  println(someTestD.SomeFunc)

  //================================перегруженные конструкты====================================
  // класс может иметь несколько конструктов, то есть несколько вариантов создания
  // как пример указание только части из параметров
  // для этого используется ключевое слово def this
  // но проще указать значения по умолчанию

  class SomeClassE(id: Int, name: String){ // основной конструкт
    def this(name : String) = this(0, name) // доп конструкт, если не укажут id
    def this(id : Int) = this(id, "NoName") // еще один доп конструкт, если не укажут name
  }

}
