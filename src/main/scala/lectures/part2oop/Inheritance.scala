package lectures.part2oop

object Inheritance extends App {

  // Single class inheritance
  sealed class Animal {
    val creatureType = "wild"
    // private -> only it owns class
    // protected -> own class and sub class
     def eat:Unit = println("nomnom")
  }

  class Cat extends Animal {
    def crunch:Unit = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // Constructors
  class Person(name: String, age: Int){
    def this(name: String) = this(name,0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name) {

  }

  // Overriding
  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType = "domestic"
    override def eat:Unit = {
      super.eat
      println("crunch, crunch")
    }
  }


//  class Dog(dogType: String) extends Animal{
//    override val creatureType: String = dogType
//    override def eat = println("crunch, crunch")
//  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // Type substitution (broad: polymorphism)
  var hello: Animal = (new Dog("K9"))
  hello.eat

  // override vs overloading

  // super

  // preventing overrides
  // 1. use final on member
  // 2. use final on class -> prevent the entire class to be extends
  // 3. seal the class (sealed) -> extends class in THIS FILE, prevent extends in OTHER FILE
}
