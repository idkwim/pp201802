package pp201802.prob4.Test
import pp201802.prob4.Data._
import pp201802.prob4.Main._

object Test extends App {
  def print_result(b:Boolean) : Unit =
    if (b) println("PASS") else println("FAIL")

  println("------Problem 4------");

  val circle: Problem4.Circle = new Problem4.Circle(10)
  val triangle: Problem4.Triangle = new Problem4.Triangle(6, 3)
  val rectangle: Problem4.Rectangle = new Problem4.Rectangle(4, 8)
  val sum = Problem4.SumOfArea(List[Shape](circle, triangle, rectangle))
  val answer = (3.14 * 10 * 10) + (6 * 3 / 2) + (4 * 8)
  print_result((answer - 0.001 < sum) && (sum < answer + 0.001))
}
