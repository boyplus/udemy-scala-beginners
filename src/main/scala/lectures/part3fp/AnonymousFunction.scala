package lectures.part3fp

object AnonymousFunction extends App {
  // override def apply -> syntactic sugar
  // anonymous function (LAMBDA)
  // compiler already know the types of args and return type (type inference)
  val doubler: Int => Int = x => x * 2

  // multiple parameters in lambda
  val adder: ((Int,Int) => Int) = (a,b) => a+b

  // no parameter
  val justDoSomething: () => Int = () => 3
  println(justDoSomething) // instance (function)
  println(justDoSomething()) // in lambda -> must use ()

  // curly braces with lambda
  val stringToInt = { (str: String) =>
    str.toInt
  }

  println(stringToInt("12")+3)

  // More syntactic sugar
  val niceIncrement: Int => Int = _+1 // equvalent to x => x+1
  // make sure that type is proper
  val niceAdder: (Int,Int) => Int = _+_ // equivalent to (a,b) => a+b

  /*
    1. MyList: replace all FunctionX calls with lambda
    2. Rewrite the "special" adder as an anonymous function
  */

  // 1. MyList.scala

  // 2
  val superAdd = (x:Int) => (y:Int) => x+y
  println(superAdd(3)(4))

  /*
    Takeaways
    Instead of passing anonymous FunctionX instances every time
    - cumbersome
    - still object-oriented
    (x,y) => x+y (lambda)
    
  */

}
