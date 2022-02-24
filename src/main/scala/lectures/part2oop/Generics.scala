package lectures.part2oop

object Generics extends App {

  class MyList[+A]{
    // use type A
    def add[B >: A](element: B): MyList[B] = ???
    /*
      A = Cat
      B = Dog = Animal
     */
  }

  class MyMap[Key,Value]{

  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfInteger = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1.Yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? -> Hard question -> we return list of Animal

  // 2. No = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no! contravariance
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  // Only subtype of animal
  // <: Animal -> accept subtype of Animal
  // >: Animal -> accept super type of Animal
  class Cage[A <: Animal](animal: A){
    val cage = new Cage(new Dog)
  }

  class Car
  // error -> Car is not a subtype of Cage
//  val newCage = new Cage(new Car)

  // expand MyList to be generic

}
