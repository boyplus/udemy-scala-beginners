package lectures.part2oop

object AbstractDataTypes extends App {
  // Abstract -> you cannot create object from that class -> other class will extends it
  // Abstract class can contain abstract and non abstract member
  abstract class Animal {
    // Abstract is to not implement the body of member
    val creatureType: String = "wild";
    def eat: Unit;
  }

  class Dog extends Animal {
    // no need to put keyword "override"
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch")
  }

  // traits
  // -> abstract + non abstract
  trait Carnivore{
    def eat(animal: Animal): Unit
    val preferedMeal: String = "fresh meat"
  }

  trait ColdBlood

  class Crocodile extends Animal with Carnivore with ColdBlood {
    override val creatureType: String  ="croc"
    def eat: Unit = println("nomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and i'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract class
  // 1 - traits do not have constructor parameter
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits  = behavior (what they do), abstract class -> type of things
}
