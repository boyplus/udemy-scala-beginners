package lectures.part1basic

import scala.annotation.tailrec

object Recursion extends App{
  def factorial(n: Int): Int = {
    // Base case
    if(n == 0)  1
    else {
//      println("Computing factorial of "+n+" - I need to compute factorial of "+(n-1))
      val result = n*factorial(n-1)
//      println("Compute factorial of "+n)
      result
    }
  }

  // Cause stack overflow -> since stack is too big
//  println(factorial(20000))

  // This way of recursion works for big number
  // It works because it doesn't need to create extra stack frame since it is last expression
  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, acc: BigInt): BigInt = {
      if(x <= 1) acc
      else factorialHelper(x-1,x * acc) // TAIL recursion -> use recursive call as the LAST expression
    }
    factorialHelper(n,1)
  }

  println(anotherFactorial(10))

  // When you need loop -> use tail recursion -> trick is to use accumulator as many as you want

  // Exercise
  // 1. Concat a string n times using tail recursion
  def concatString(aString: String,n: Int): String = {
    @tailrec
    def concatHelper(x: Int, acc: String): String = {
      if(x == 0) acc
      else concatHelper(x-1, acc+aString)
    }
    concatHelper(n,"")
  }
  println(concatString("boy",3))


  // 2. isPrime function tail recursive
  def isPrime(n:Int): Boolean = {
    @tailrec
    def isPrimeHelper(x: Int): Boolean = {
      if(x == 1) true
      else if(n%x == 0) false
      else isPrimeHelper(x-1)
    }
    isPrimeHelper(n-1)
  }
  println(isPrime(2000000))


  // 3. Fibonacci function, tail recursive
  def fib(n: Int): Int ={
    @tailrec
    def fibHelper(x: Int,acc1: Int, acc2: Int): Int = {
      if(x == 1 || x == 2) 1
      else if(x == n) acc1+acc2
      else fibHelper(x+1,acc2,acc1+acc2)
    }
    fibHelper(3,1,1)
  }
  // 1 1 2 3 5 8 13
  println(fib(7))
}
