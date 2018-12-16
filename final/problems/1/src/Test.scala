package pp201802.prob1.Test
import pp201802.prob1.Data.DataBundle._
import pp201802.prob1.Main.Problem1._

object Test extends App {
  def print_result(b:Boolean) : Unit =
    if (b) println("PASS") else println("FAIL")

  println("------Problem 1------");

  val a = 2.0
  val b = 3.0
  print_result(implicitly[AddOp[Real]].op(a, b) == 5.0)
  print_result(implicitly[MultOp[Real]].op(a, b) == 6.0)

  val c = List(1.0, 2.0, 1.0)
  val d = List(3.0, 7.0)
  print_result(implicitly[AddOp[Poly[Real]]].op(c, d) == List(4.0,9.0,1.0))
  print_result(implicitly[MultOp[Poly[Real]]].op(c, d) == List(3.0,13.0,17.0,7.0))

  print_result(eval(c, a) == 9.0)
}
