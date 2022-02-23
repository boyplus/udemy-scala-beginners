package lectures.part2oop

import scala.language.postfixOps

/*
  1.  Overload the + operator
      mary + "the rockstar" => new person "Mary (the rockstar)"
  2.  Add an age to person class
  Add a unary + operator => new person with the age+1
  +mary => mary with the age increment

  3. Add a "learns" method on the person class => "Mary learns Scala"
  Add a learnScale method calls method with "Scala"
  Use it in postfix notation

  4. Overload the apply method
  mary.apply(2) => Mary watched Inception 2 times

 */

object MethodNotations extends App {
  class Person(val name: String, favMovie: String, val age: Int){
    def likes(movie: String): Boolean = favMovie == movie
    def hangoutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(person: Person): String = hangoutWith(person)
    def +(aString: String): Person = new Person(s"$name ($aString)",favMovie,age)


    // Need to put space between : and name
    def unary_! : String = s"$name, what the heck!"
    def unary_+ : Person = new Person(this.name,favMovie,this.age+1)

    def learns(subject: String): String = s"$name learns $subject"
    def learnsScala : String = this.learns("Scala")

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favMovie"
    def apply(n: Int): String = s"$name watched $favMovie $n times"

  }

  val mary = new Person("Mary","Inception",20)
  println(mary.likes("Inception"))

  // Method Notation
  println(mary likes "Inception") // equivalent (only one parameter)
  // infix notation = operator notation (syntactic sugar)

  // "operators" in Scala
  val tom = new Person("Tom","Fight Club",19)
  println(mary hangoutWith tom) // you can think hangoutWith as an +,-,*,/
  // You can also define method with name of +,-,*,/
  println(mary+tom)
  println(mary.+(tom))

  println(1+2)
  println(1.+(2))

  // All operators are METHODS
  // Akka actors have ! ?

  // Prefix notation -> all about unary operator
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_prefix only works with - + ~ !
  println(!mary)
  println(mary.unary_!)

  // postfix notation -> can use for function with no parameter
  println(mary.isAlive)
  println(mary isAlive)

  // Apply
  println(mary.apply)
  println(mary()) // equivalent -> it looks for apply function

  // Test exercise
  // 1
  println((mary + "rockstar").name)

  // 2
  println((+mary).age)

  // 3
  println(mary learns "C++")
  println(mary learnsScala)

  // 4
  println(mary.apply(3))
}

/*
Takeaways
1. Infix notation
-> object method parameter
-> ex. mary likes "Inception"

2. Prefix notation -> only allowed for + - / ~
-> mary.unary_!
-> !mary


3. Postfix notation
-> mary.isAlive
-> mary isAllive

 */
