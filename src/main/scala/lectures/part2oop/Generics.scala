package lectures.part2oop

object Generics extends App {

  class MyList[A]{
    // use type A
  }

  class MyMap[Key,Value]{

  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfInteger = MyList.empty[Int]
}
