package lectures.part1basic

object Expression extends App{
  val x = 1+2 // Expression
  println(x)

  println(2+3*4)

  println(1==x)
  // == != > >= < <=

  println(!(1==x))
  // ! && ||

  var aVar = 2;
  aVar+=3 // Also works with -= *= /=
  println(aVar)

  // Instruction (To do) VS Expression (Boolean value)

  // If expression (not instruction) get back the value
  val aCondition = false
  val aConditionValue = if(aCondition) 5 else 3
  println(aConditionValue)

  println(if(aCondition) 5 else 3)

  // Never write this again
  // Since it's imperative programming (now we use scala -> functional)
  var i=0
  var aWhile = while(i< 10){
    print(i+" ")
    i+=1
  }

  // Everything in scala is an Expression!
  val aWeirdValue = (aVar = 3) // Unit === void
  print(aWeirdValue)

  // side effect: println(), whiles, reassigning

  // Code blocks -> is expression -> the value will be the last expression
  // var is visible only inside the block
  val aCodeBlock = {
    val y = 2
    val z = y+1
    if(z > 2) "hello" else "goodbye"
  }

  // we cannot access z (out of scope)
  // val anotherValue = z+1;

  // Instruction are executed (think java), expressions are evaluated (scala)
  // In scala we think as an expression

  // 1.Difference between "hello world" vs println("hello world") ?
  // "hell world" is a string with value of "hello world"
  // println("hello world") is the expression which return Unit it also has side effect
  // print string hello world



  // 2.
  val someValue = {2<3}

  val someOtherValue = {
    if(someValue) 239 else 986
  }

  // someValue will be true
  // someOtherValue will be 239

  println()
  println(someValue)
  println(someOtherValue)

}
