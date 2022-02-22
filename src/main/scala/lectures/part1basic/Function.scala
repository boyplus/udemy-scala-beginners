package lectures.part1basic

object Function extends App {
  // It is optional to indicate the return type since it can infer from code
  def aFunction(a: String,b: Int): String = {
    a+" "+b;
  }

  println(aFunction("boy",20))

  def aParameterLessFunction(): Int = 42

  println(aParameterLessFunction())
  // If there is no parameter in function, we can call without parentheses
  println(aParameterLessFunction)

  // For recursive function, we need to tell the return type !!
  // Always indicate the return type is best practice
  def aRepeatedFunction(aString: String, n: Int): String = {
    if(n == 1) aString
    else aString+aRepeatedFunction(aString,n-1)
  }

  println(aRepeatedFunction("hello",3))

  // When you need loops, use recursion.
  // But we can still use imperative style

  def aFunctionWithSideEffect(aString: String): Unit = println(aString)
  aFunctionWithSideEffect("hello world")

  // we can define a function inside
  def aBigFunction(n: Int): Int = {
    def aSmallFunction(a: Int, b:Int): Int = a+b

    // Here is return of a function
    aSmallFunction(n,n-1)
  }

  println(aBigFunction(10))

  // Exercise
  // 1. A greeting function (name,age) => Hi my name is $name and I am $age years old
  def greeting(name: String, age:Int): String = "Hi my name is "+name+" and I am "+age+" years old"
  println(greeting("Thanaphon",21))

  // 2. Factorial function
  def factorial(n: Int): Int = {
    if(n == 0) 1
    else n*factorial(n-1)
  }
  println("5! is "+factorial(5))



  // 3. A Fibonacci function
  def fib(n: Int): Int = {
    if(n <= 2) 1
    else fib(n-1)+fib(n-2)
  }
  println("The fourth fib is "+fib(4))

  // 4. Tests if a number is prime
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if(t <= 1) true
      else n%t !=0 && isPrimeUntil(t-1)
    }
    isPrimeUntil(n/2)
  }
  println(isPrime(29))
  println(isPrime(25))

}
