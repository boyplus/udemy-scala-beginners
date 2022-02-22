package lectures.part1basic

object CBNcsCBV extends App{
  def calledByValue(x: Long): Unit ={
    println("by value: "+x)
    println("by value: "+x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: "+x)
    println("by name: "+x)
  }

  // For by value -> its value is evaluated and use it in the entire function
  calledByValue(System.nanoTime())

  // For by name -> Value is executed everytime we invoke that variable
  calledByName(System.nanoTime())

  def infinite(): Int = 1+infinite()

  def printFirst(x: Int, y: => Int) =  println(x)

  // It will crash
//  printFirst(infinite(),34)

  // It won't crash because value of y is never use, so it's not executed infinite() at all
  printFirst(34,infinite())
}
