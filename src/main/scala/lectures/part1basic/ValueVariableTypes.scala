package lectures.part1basic

object ValueVariableTypes extends App{
  // Type of val is optional since it can infer from the right hand side
  // val x: Int = 5
  val x = 5;
  println(x)

  // val is IMMUTABLE
  //  x = 2;

  // ; is optional in scala
  // ; is essential when we write multiple cmd in one line
  val aString:String = "Hello world"
  print(aString)

  val aBoolean: Boolean = true
  val aChar: Char = 'C'
  val aInt: Int = x
  val aShort: Short = 444
  // Mark the number as a Long by adding 'L' after number
  val aLong: Long = 289237923129192812L

  // Mark the number as a float by adding 'f'
  val aFloat: Float = 3.1415f
  var aDouble: Double = 3.14

  // Variable is mutable
  var aVar: Int = 13
  aVar = 5 // side effect
}
