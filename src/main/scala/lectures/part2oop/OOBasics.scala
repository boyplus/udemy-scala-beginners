package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John",26)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  val non = new Person
  println(non.name)

  val boy = new Writer("Thanaphon","Sombunkaeo",2000)
  println(boy.fullname)

  val james = new Writer("James","Mongkol",2001)

  val novel = new Novel("C programming",2015, boy)
  println(novel.authorAge)
  println(novel.isWrittenBy(boy))
  println(novel.isWrittenBy(james))

  val counter = new Counter(12)
  counter.inc.print
  counter.inc.inc.print
  counter.inc(10).print

}

// Exercise
/*
  Novel and a Writer

  Writer: firstname, surname, year
  - method fullname

  Novel: name, year of release, author
  - author age (at the year of release)
  - isWrittenBy(author)
  - copy (new year of release) = new instance of novel
 */

class Writer(val firstname: String, val surname: String, val year: Int){
  def fullname: String = s"$firstname $surname"
}

class Novel(val name: String, val year: Int, val author: Writer){
  val authorAge: Int = year - author.year
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def copy(newYaer: Int) = new Novel(name,newYaer, author)
}
 
class Person(val name: String, val age: Int) /*Constructor*/ {
  // Class parameters are not FIELDS
  // To make parameter as the field -> add "val" keyword

  // body -> implementation of class
  // val, var inside class will be field
  val x = 2
  println(x+2)

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors -> can call the primary constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

/*
  Counter class
  - receive an int value
  - method current value
  - method to increment/decrement -> new counter
  - overload inc/dec to receive an amount
 */

class Counter(val count: Int){
  def inc: Counter = {
    println("Incrementing")
    new Counter(count+1)
  }
  def dec: Counter = {
    println("Decrementing")
    new Counter(count-1)
  }

  def inc(n: Int): Counter = {
    if(n <= 0) this
    else inc.inc(n-1)
  }
  def dec(n: Int): Counter = {
    if(n<=0) this
    else dec.dec(n-1)
  }

  def print = println(count)
}
