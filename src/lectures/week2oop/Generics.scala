package lectures.week2oop

object Generics extends App {
  // ====================================обобщения (Generics)==========================================
  // с целью возможности замены типов данных в методах, существуют обобщения
  // обобщения - это такая штука, которая позволит использовать один и тот же код для разных типов данных
  // для написания универсальной функции в качестве типа данных нужно указать "обобщенный" тип данных
  //         (любая заглавная буква латинского алфавита) в квадратных скобках после названия метода
  // например вот так
  def createElement[A](el : A) : A = el
  // теперь в качестве el можно передать значения любого вида
  println(createElement("String"))
  println(createElement(2))

  // также обобщенные типы данных можно использовать при создании класса
  // и вписать необходимые типы данных в процессе инициализации нового экземпляра класса

  class SomeClass[B, C] {
    def someFunc(fEl : B, sEl : C) : Unit = println(s"first is ${fEl.getClass.getSimpleName}, second is ${sEl.getClass.getSimpleName}")
  }
  val aVar = new SomeClass[Int, String]
  aVar.someFunc(2, "2")

  // =========================================ограничения типов при обощении===========================
  // разбирать будем на иерархии классов, следующей ниже:
  //                                              Thing
  //                                                |
  //                                             Vehicle
  //                                        |------------------|
  //                                      Car               Bicycle
  //                        |-------------|---------|             |
  //                 Ambulance          Taxi      Jeep        Tricycle

  trait Thing
  class Vehicle extends Thing
  class Car extends Vehicle
  class Ambulance extends Car
  class Taxi extends Car
  class Jeep extends Car
  class Bicycle extends Vehicle
  class Tricycle extends Bicycle

  // далее пропишем класс Parking
  //class Parking[T](val vehicle: T)

  // при объявлениии обобщенного класса в качестве обощения, помимо класса передаваемого параметра
  // можно передать и его родительский(или выше по цепочке) класс
  // например можно в качестве параметра передать класс Taxi, а в качестве обощения передать класс Taxi
  val testParentClass = new Parking[Car](new Taxi)
  println("The line above works")


  // для того чтобы ограничить возможные обобщения существует ограничение типов
  // верхнее ограничение <:
  // нижнее ограничение >:

  class Parking[T >: Bicycle <: Vehicle](val vehicle: T)
  new Parking[Thing]()
}
