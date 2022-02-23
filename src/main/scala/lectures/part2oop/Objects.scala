package lectures.part2oop

object Objects{

  // Scala does not have class-level functionality ("static")
  object Person { // type + its only instance
    // "static/class-level functionality"
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def from(mother: Person, father: Person): Person = new Person("Bobbie")
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")

  }

  class Person(val name: String) {
    // instance-level funcationality
  }

  def main(args: Array[String]): Unit = {

    // Companions

    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = singleton instance
    val mary = new Person("mary")
    val john = new Person("John")
    println(mary == john)

    val person1 = Person
    val person2 = Person
    println(person1 == person2) // true since it point to the same instance

    //  val bobbie = Person.from(mary,john)
    val bobbie = Person(mary,john)

    // Scala Applications = Scala object with
    // def main(args: Array[String]): Unit
    // Or just extends App which already contain main method
  }


}
