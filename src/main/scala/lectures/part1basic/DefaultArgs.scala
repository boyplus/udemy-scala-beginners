package lectures.part1basic

object DefaultArgs extends App {
  def trFact(n: Int, acc: Int = 1): Int = {
    if(n<=1) acc
    else trFact(n-1,n*acc)
  }

  println(trFact(5))

  def savePicture(format: String = "jpg", width: Int=1920, height: Int=1080): Unit= println("Saving picture...")
  // It does not work since we use positional parameter
//  savePicture(800,600)

  // Solution
  /*
    1. pass in every leading argument
    2. name the arguments
  */

  savePicture(height=600,width = 800, format = "png")
  savePicture(height=600, format = "png")
}
