package exercises

abstract class MyList[+A] {
  /*
    head = first element of the list
    tail = remainder of the list
    isEmpty = is this list empty
    add(int)=> new List with this element added
    toString => a string representation of the list
   */

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"

  // higher-order function -> function that return function or receive function as parameter
  def map[B](transformer: A=>B): MyList[B]
  def flatMap[B](transformer: A=>MyList[B]): MyList[B]
  def filter(predicate: A=>Boolean): MyList[A]

  // Concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]
}

//trait MyPredicate[-T]{ // T => Boolean
//  def test(element: T): Boolean
//}
//
//trait MyTransformer[-A,B]{ // A => B
//  def transform(element: A): B
//}

//class EvenPredicate[Int] extends MyPredicate[Int]{
//  override def test(n: Int): Boolean = {
//
//  }
//}


case object Empty extends MyList[Nothing] {
  // ??? is default implementation -> we will implement them later
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B ): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String = {
    if(t.isEmpty) ""+h
    else "" + h + " " + t.printElements
  }

  def filter(predicate: A=>Boolean): MyList[A] = {
    // head is included in result
    if(predicate(head)) new Cons(h,t.filter(predicate))
    else tail.filter(predicate)
  }

  def map[B](transformer: A=>B): MyList[B] = {
    new Cons[B](transformer(h), t.map(transformer))
  }

  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons[B](h,t++list)

  def flatMap[B](transformer: A=>MyList[B]): MyList[B] = {
    transformer(h)++t.flatMap(transformer)
  }
}



object ListTest extends App{
//  val list = new Cons(1,new Cons(2,new Cons(3, Empty)))
//  println(list.head)
//  println(list.tail.head)
//  list.add(4)
//  println(list.isEmpty)
//
//  println(list.toString)

  val listOfInteger: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val cloneListOfInteger: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfInteger: MyList[Int] = new Cons(4, new Cons(5, new Cons(6, Empty)))
  val listOfString: MyList[String] = new Cons[String]("Hello", new Cons[String]("Scala", Empty))

  println(listOfInteger.toString)
  println(listOfString.toString)

  println(listOfInteger.map(el=>el*2).toString)

//  println(listOfInteger.filter(new Function1[Int,Boolean] {
//    override def apply(element: Int): Boolean = element%2 == 0
//  }).toString)

  println(listOfInteger.filter(x => x%2 == 0))

  println(listOfInteger++anotherListOfInteger)

//  println(listOfInteger.flatMap(new Function1[Int, MyList[Int]] {
//    override def apply(element: Int): MyList[Int] = {
//      new Cons[Int](element, new Cons[Int](element+1,Empty))
//    }
//  }).toString)

  println(listOfInteger.flatMap(element => new Cons(element, new Cons[Int](element+1,Empty))).toString)

  // Since case class already have equals() method, we can compare directly
  println(cloneListOfInteger == listOfInteger)

}