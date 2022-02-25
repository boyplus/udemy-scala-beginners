package lectures.part2oop

// It will group the import together
// Can also use import playground._
// use => for aliasing in case we have more than one class with the same name
import playground.{Cinderalla => Princess, PrinceCharming}

import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {
  // package members are accessible by their simple name
  val writter = new Writer("Thanaphon","Sombunkaeo",21)
  val princes = new Princess
  // Fully qualified name
//  val princes2 = new playground.Cinderalla

  // packages are in hierarchy
  // matching folder structure

  // package object
  // we do not need to import them since it is package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  // 1. use fully qualified name
  val date = new java.util.Date
  val sqlDate = new java.sql.Date(2018,5,4)

  // 2. use name aliasing
  val aliasSqlDate = new SqlDate(2018,5,4)

  // default imports
  // java.lang -> String, Object, Exception
  // scala -> Int, Nothing, Function
  // scala.Predef -> println, ???
}
