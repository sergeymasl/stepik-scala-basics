package lectures.week2oop



object SyntacticSugar extends App {
  // =============================синтаксический сахар (Syntactic Sugar)==========================================

  // ------------------ инфиксная нотация (Infix notation)
  // инфиксная нотация работает ТОЛЬКО для методов с ОДНИМ параметром
  // она позволяет заменить точечную нотификацию на более естественный язык
  // например
  class Person(val name : String, occupation : String){
    def worksAt(jobName : String) : Boolean = jobName == occupation
    def speaksEnglish: Boolean = true
  }
  // метод worksAt имеет только один параметр
  val hex = new Person("Hex", "Wox Machine")
  // вызов метода через обычную точетную нотацию
  println(hex.worksAt("Wox Machine")) // true
  // а теперь через синтаксичесткую нотификацию
  println(hex worksAt "Wox Machine")


  // ------------------ Постфиксная нотация (Postfix notation)
  // постфиксная нотация используется если у методов нет параметров
  // работает также как и инфиксная
  // ЛУЧШЕ ЕЁ НЕ ИСПОЛЬЗОВАТЬ
  // НО начиная со Scala 2.13 от нее постепенно уходят и нужно доп. импортирование
  import scala.language.postfixOps
  println(hex speaksEnglish)

  // ------------------ условности с операторами
  // операторы в Scala на самом деле являются методами
  println(1 + 1) // обычное обращение
  println(1.+(1)) // точечная нотификация

  // также операторы можно использовать как имя метода
  // добавим метод & в класс Person

  class PersonWithAnd(name : String, occupation : String) extends Person(name, occupation){
    def &[T <: Person](otherPerson : T) : String = s"$name and ${otherPerson.name} is colleg"
  }
  val vax = new PersonWithAnd("vax", "Wox Machine")
  val vex = new PersonWithAnd("vex", "Wox Machine")
  // а так как у метода & всего один параметр, то мы можем использовать инфиксную нотификацию
  println(vax.&(hex)) // точечная нотация
  println(vax & vex) // инфиксная нотация

  // ------------------- префиксная нотация (Prefix notation)
  // префиксная нотация это вызов метода с помощью прописания некоевого символа перед значением
  // для вызова такой функции используется префикс unary_
  // префикс unary_ подходит ТОЛЬКО для + - ~ !
  // например
  val x = -1 // стандартный вызов
  val y = 1.unary_- // через префикс
  println(x == y)

  // оператор с unary_ тоже можно использовать в качестве имени функции
  class PersonWithUnary(name : String, occupation : String) extends Person(name, occupation){
    def unary_! : String = s"$name is not real"
  }
  val scanlan = new PersonWithUnary("Scanlan", "Wox Machine")
  println(scanlan.unary_!) // точечная нотификация
  println(scanlan unary_!) // постфиксная нотификация (т.к. у метода нет параметров)
  println(!scanlan) // префиксная нотификация

  // ======================================= apply ============================================
  // если в коде будет написан вызов метода у класса с пустыми скобками
  // вот так person()
  // то это метод apply
  class PersonWithApply(name: String, occupation : String) extends Person(name, occupation){
    // вот он
    def apply() : String = s"$name works at a $occupation"
  }
  val kilet = new PersonWithApply("Kilet", "Wox Machine")
  println(kilet.apply()) // точечная нотификация
  println(kilet()) // вызов apply без прописания самого метода
}
