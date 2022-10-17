package lectures.week2oop

object CaseClasses extends App{
  //======================================классы образцы (case classes)============================================
  // для создания класса образца необходимо использовать ключевое слово case
  case class Person(name : String, occupation : String)


  // ---------------------доступ к параметрам
  // все параметры case классов по умолчанию являются val полями
  // то есть к любым параметрам классов можно получить доступ

  val caseClass = new Person("Tiberius", "Vox Machine")
  println(caseClass.name) // в обычном классе нельзя получить доступ к параметру без указания val перед параметром


  // -------------------метод toString
  // каждый case class имеет метод toString
  // метод toString позволяет при print экземпляра класса избалять нас от абракадабры
  // сравним
  class PriPerson(name : String, occupation : String) // обычный класс
  val priClass = new PriPerson("Perci", "Vox Machine")

  println(priClass) //lectures.week2oop.CaseClasses$PriPerson@26ba2a48
  println(caseClass.toString) // Person(Tiberius,Vox Machine)
  println(caseClass) // toString имеет некий синтаксический сахар и этот метод можно не прописывать


  // -------------------метод equals
  // существует два принципа метода equals( == )
  // reference level equality - сравнение по ссылкам но объекты
  // content level equality - сравнение по параметрам у сравниваемых объектов

  // case classes ВСЕГДА имеют набор параметров даже если он пустой
  // для case class метод equals сравнивает ПО параметрам, то есть content level equality
  // поэтому если мы создадим два объекта case class с одинаковыми параметрами
  // то при вызове метода equals он выдаст true

  // сравнение case class
  val first_case_percy = new Person("Percy", "Vox Machine")
  val second_case_percy = new Person("Percy", "Vox Machine")
  println(first_case_percy.equals(second_case_percy)) // true т.к. это case class и параметры одинаковые
  println(first_case_percy == second_case_percy) // syntaxis sugar

  val first_pri_percy = new PriPerson("Percy", "Vox Machine")
  val second_pri_percy = new PriPerson("Percy", "Vox Machine")
  println(first_pri_percy == second_pri_percy) // false т.к. проверяется один ли это экземпляр или нет


  // -------------------метод copy
  // для классов экземпляров доступен метод copy
  // позволяющий как полностью скопировать ЭКЗЕМПЛЯР класса
  // так и с ИЗМЕННЕНЫМИ элемантами КОНСТРУКТА
  val caseClassCopy = caseClass.copy()
  val caseClassWithAnotherArguments = caseClass.copy(name = "NOT Tiberius")
  println(caseClass) // Person(Tiberius,Vox Machine)
  println(caseClassCopy) // Person(Tiberius,Vox Machine)
  println(caseClassWithAnotherArguments) // Person(NOT Tiberius,Vox Machine)


  // -------------------объект компаньен и метод apply
  // КАЖДЫЙ case class имеет объект-компаньен
  // в объекте-компаньене ВСЕГДА есть метод apply, который позволяет присваивать
  // новый экземпляр класса БЕЗ ключевого слова new
  val valWithOutNew = Person("I have no word NEW", "Vox Machine") // создали новый экземпляр класса без new




}
