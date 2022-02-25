package lectures.part2oop

object Exceptions extends App {
  val x: String = null
  // null.length -> crash with Null pointer exception
//  print(x.length)

  // 1. throwing and catching exceptions
  // expression -> return Nothing (Nothing is subtype of String)
//  val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes

  // 2. how to catch exceptions
  def getInt(withException: Boolean): Int = {
    if(withException) throw new RuntimeException("No int for you")
    else 42
  }

  val potentialFail = try {
    // code that might throw
    getInt(false) // -> will get Int
  } catch {
        // IF we did not catch the correct error -> we will see error
    case e: RuntimeException => 43 // will get Unit
      // that's why we see we get AnyVal in potentialFail
  } finally {
    // code that will get executed NO MATTER WHAT!!
    // optional
    // does not influence the return type of expression
    // use finally only for side effect
    println("Finally")
  }

  println(potentialFail)

  // 3. How to define your own exception
  class MyException extends  Exception
  val exception = new MyException

//  throw exception

  /*
      Exercise
      1. Crash your program with OutOfMemoryError
      2. Crash with SOError
      3. PocketCalculator
          - add(x,y)
          - multiply(x,y)
          - divide(x,y)
          - subtract(x,y)
        Throw
          - OverflowException if add(x,y) exceeds Int.MAX_VALUE
          - UnderFlowException if subtract(x,y) exceeds Int.MIN_VALUE
          - MatchCalculationException for division by 0
  */

  // 1.OOM
//  val array = Array.ofDim(Int.MaxValue)

  // 2.SO
//  def infinite: Int = 1+infinite
//  val noLimit = infinite


  // 3. Pocket
  // can use any exception type
  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MatchCalculationException extends RuntimeException("Divide by 0 is not allowed")

  object PocketCalculator{
    def add(x: Int,y: Int): Int = {
      val result = x+y
      if(x >0 && y > 0 && result > Int.MaxValue) throw new OverflowException
      else if(x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int,y: Int): Int = {
      val result = x-y
      if(x >0 && y < 0 && result < 0) throw new OverflowException
      else if(x < 0 && y >0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x*y
      if(x > 0 && y > 0 && result < 0) throw new OverflowException
      else if(x < 0 && y < 0 && result < 0) throw new OverflowException
      else if(x < 0 && y > 0 && result > 0) throw new UnderflowException
      else if(x > 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int,y: Int): Int = {
      if(y == 0) throw new MatchCalculationException
      else x/y
    }
  }

  println(PocketCalculator.divide(10,0))

}
