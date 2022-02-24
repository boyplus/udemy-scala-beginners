package lectures.part2oop

object CaseClasses extends App{
  /*
    equals, hashCode, toString
   */

  case class Person(name: String, age: Int){

  }

  // 1. class parameter are fields
  val jim = new Person("Jim",20)
  println(jim.name)

  // 2. sensible toString
  // println(instance) -> println(instance.toString)
  println(jim.toString)
  println(jim)

  // 3. equals and hashCode implemented OOTB (Out of the Box)
  val jim2 = new Person("Jim",20)
  println(jim == jim) // compare the address
  println(jim.equals(jim2)) // compare the value inside instance

  // 4. CCs have handy copy method -> can also indicate some unique value
  val jim3 = jim.copy(age = 45)
  println(jim3)


  // 5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary",23) // will invoke the apply method (in this case is constructor)
  // so, we do not need to use "new" to create instance

  // 6. CCs are serializable
  // Akka -> deal with sending serializable object accross network

  // 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  // Exercise
  // Expand MylLst -> use case class and case object


}
