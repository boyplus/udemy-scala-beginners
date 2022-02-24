package lectures.part2oop

object AnonymousClasses extends App{

  abstract class Animal{
    def eat: Unit
  }

  // Anonymous class
  // Compiler will create a new class for us like "AnonymousClasses$$anon$1"
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahhh")
  }
  println(funnyAnimal.getClass)

  class Person(name: String){
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  // It works although Person is not an abstract class
  // we can override on the anonymous class
  val jim = new Person("Jim"){
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be service?")
  }

  /*
    1. Generic trait MyPredicate[-T] with a little method test(T) => Boolean
    2. Generic trait MyTransformer[-A,B]
    3. MyList
      - map(transformer) => MyList
      - filter(predicate) => MyList
      - flatMap(transformer from F to MyList[B]) => MyList[B]

      class EvenPredicate extends MyPredicate[Int]
      class StringToIntTransformer extends MyTransformer[String,Int]

      [1,2,3].map(n*2) = [2,4,6]
      [1,2,3,4].map(n%2) = [2,4]
      [1,2,3].flatMap(n => [n,n+1]) = [1,2,2,3,3,4]
   */

}
