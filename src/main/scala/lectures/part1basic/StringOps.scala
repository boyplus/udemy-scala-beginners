package lectures.part1basic


object StringOps extends App{
  // String function is same as java function
  val str: String = "Hello, I am learning scala"

  println(str.charAt(2))
  println(str.substring(7,11))

  // .toList is without ()
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ","-"))
  println(str.toLowerCase())
  println(str.toUpperCase())

  // .length is without ()
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println(aNumber)

  val x = List(1,2,3,4) :+ 400
  println(x)
  println('a'+ aNumberString + 'z')
  println(str.reverse)
  println(str.take(2))

  // Scala-specific: String interpolators

  // S-interpolator
  val name = "David"
  val age = 12
  // Need to out s in front of string
  val greeting = s"Hello, my name is $name and I am ${age} years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age+1}"

  println(greeting)
  println(anotherGreeting)

  // F-interpolator -> format the floating point number -> similar to printf()
  // It also has type check error
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.3f burgers"
  println(myth)

  // raw-interpolator -> print raw string (string is not escaped)
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  print(raw"$escaped")
}
