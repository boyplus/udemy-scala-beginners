package lectures.part3fp

object WhatsAFunction extends App {
  // DREAM : use functions as first class element
  // problem: OOP

  val doubler = new MyFunction[Int,Int] {
    override def apply(element: Int): Int = element*2
  }

  // doubler like a function (it is an instance of class)
  println(doubler(2))

  // Function types = Function1[A,B]
  val stringToIntConverter = new Function[String,Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("12")+4)

  // Function2 is a function which receive two arguments
  val adder: ((Int,Int) => Int) = new Function2[Int,Int,Int] {
    override def apply(a: Int, b: Int): Int = a+b
  }

  // Function types Function2[A,B,R] === (A,B) => R

  // All scala function are object!!!

  // Exercise
  /*
      1. a function which takes 2 strings and concatenate them
      2. transform the MyPredicate and MyTransformer into function types
      3. define a function which takes an int and return another function which takes an int and returns an int
        - what's the type of this function
        - how to do it
   */

  // 1
  val concat: ((String,String) => String) = new Function2[String,String,String] {
    override def apply(a: String, b: String): String = a + b
  }
  println(concat("boy","plus"))

  // 2. -> MyList.scala

  // 3.
  val superAdder: Function[Int, Function[Int,Int]] = new Function[Int,Function1[Int,Int]] {
    override def apply(x: Int): Function1[Int,Int] = new Function[Int,Int] {
      override def apply(y: Int): Int = x+y
    }
  }
  val adder3 = superAdder(3)
  println(adder3(5))

  println(superAdder(4)(3)) // curried function

  // Takeaways
  /*
    we want to work with functions
      - pass function as parameter
      - use function as values
    Problem: scala works on top of the JVM
      - designed for Java
      - first-class elements: objects (instances of classes)
    Solution: All Scala function are objects!
      - function traits, up to 22 params
      - syntactic sugar function types

    trait Function1[-A,B]{
      def apply(element: A): B = ???
    }
    From
    Function2[Int, String, Int] to (Int,String) => Int
  */
}

trait MyFunction[A,B] {
  def apply(element: A): B = ???
}
