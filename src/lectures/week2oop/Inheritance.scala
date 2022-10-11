package lectures.week2oop

object Inheritance extends App{
  //==========================================наследование===========================================
  // наследование -способ получить доступ к полям и методам РОДТЕЛЬСКОГО класса (если они НЕ private)
  // это происходит с помощью ключевого слова extends
  // наследование возможно только от одного класса

  // родительчкий класс
  class Person {
    def greet: String = "Hello"
  }
  // подкласс
  class Student extends Person

  val StudentA = new Student
  println(StudentA.greet) // получение метода из родительского класса

  //==================================private and protected===========================================
  // переменные и методы private не доступны для подклассов
  // для таких случаев есть protected переменные и классы
  // они доступны для классов и их подклассов, но не доступны вне их тел

  //=============================extend для класса с параметрами======================================
  // если родительский класс имеет в КОНСТРУКТЕ параметры и при этом НЕ имеет значений по умолчанию
  // то при создании подкласса необходимо указать в КОНСТРУКТЕ ПОДкласса параметры ДЛЯ родительского класса
  // и совершить вызов конструкта Родительского класса
  // вот так - SubClass(StudAge : Int, StudName : String, someval : String) extends ParentClass(StudAge, StudName)
  class PersonA(age : Int, name : String)
  class StudentA(StudAge : Int, StudName : String, id : Int) extends PersonA(StudAge, StudName)


  //================================переопределение (override)========================================
  // метод override позволит переопределить методы или переменные родительского класса

  // родительский класс
  class PersonB(age : Int, name : String)  {
    protected val gender : String = "Male"
    protected def greet : String = "Hello"
  }
  // подкласс
  class StudentB(age : Int, name : String, StudGender : String) extends PersonB(age, name){
    override val gender = StudGender // переопределение переменной родительского класса
    // так же можно переопределить сразу в конструкте // override val gender : String
    override def greet: String = s"Hello $name" // переопределили метод родительского класса
  }

  //===================================super==============================================
  // ключевое слово super необходимо для вызова метода или переменной родительского класса
  // при их переопределении

  class StudenC(age : Int, name : String, StudGender : String) extends PersonB(age, name){
    override def greet: String = s"${super.greet}, $name" // переопределили метод используя его же
  }

  //=============================защита от переопределения================================
  // защита от переопределения происходит с помощью ключевого слова final
  // защитить от переопределения можно отдельные переменные и/или методы
  final def SomeMethodod(someString : String) : String = s"It's $someString"
  // или целый класс
  final class SomeClass
  // также можно использовать ключевое слово sealed для класс
  // оно позволяет переопределять класс в текущем файле
  // НО запрещает переопределение вне текущего файла


  //===============================абстрактные классы (abstract classes)===================
  // абстрактный - значит на заполненый (без значения)
  // абстрактные классы - это когда родительский класс имеет переменные и/или методы без значений
  // в каждом подклассе от абстрактного должны быть определены все абстрактные методы и переменные

  abstract class AbstartParentClass(dataName : String){
    // абстракный класс может иметь НЕабстрактных членов
    val someName : String = "SomeName in Parent abstract class"
    // а теперь абстрактные члены
    val name : String
    def connect : String
  }
  // чтобы определить подкласс от родительского абстрактного класса
  // нужно ИМПЛЕМЕНТИРОВАТЬ все абстрактные методы и переменные

  class SonOfAbstract(ds : String) extends AbstartParentClass(ds){
    // необходимо определить абстрактный метод и переменную
    // ключевое слово override можно опустить в этом случае
    def connect: String = s"The class - $ds is connect"
    val name: String = s"$ds"
  }

  //================================анонимные классы(anonymous classes)====================
  // если создать экземпляр абстрактного класса и переопределить при этом абстрактые составляющие
  // то создастся анонимный класс (хер его знает зачем это нужно)

  val someVal = new AbstartParentClass("DataName") {
    override val name: String = s"someName"
    override def connect: String = s"val name is $name"
  }
  println(someVal.getClass) // lectures.week2oop.Inheritance$$anon$1

  // ===============================трейты (traits)========================================
  // трейты это некие дополнительные переменные параметры которые можно добавить при создании класса
  // задается ключевым словом trait
  // - трейты не могут задоваться с параметрами
  // - можно указать несколько трейтов для одного класса
  // - трейты описывают конкретное поведение для конкретной ситуации

  trait FirstTraid {
    def firstDef : Boolean = true
  }

  trait SecondTraid {
    def secondDef : String
  }

  class NewClassWithTraid (name : String) extends FirstTraid with SecondTraid {
    override def secondDef : String = s"The firstDef is $firstDef"
  }
}
