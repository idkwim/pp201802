package pp201802.prob5.Test
import pp201802.prob5.Data._
import pp201802.prob5.Main._

object Test extends App {
  def print_result(b:Boolean) : Unit =
    if (b) println("PASS") else println("FAIL")

  println("------Problem 5------");

  val circle: Circle = new Circle(10)
  val triangle: Triangle = new Triangle(6, 3)
  val rectangle: Rectangle = new Rectangle(4, 8)
  val sum = Problem5.SumOfArea(List[Problem5.MyT](circle, triangle, rectangle))
  val answer = circle.circle_area + triangle.triangle_area + rectangle.rectangle_area
  print_result((answer - 0.001 < sum) && (sum < answer + 0.001))
}
