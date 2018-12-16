package pp201802.prob2.Test
import scala.util._
import reflect.runtime.universe.typeOf
import pp201802.prob2.Main._
import pp201802.prob2.Data._

object Test extends App {
  def print_result(b:Boolean) : Unit =
    if (b) println("PASS") else println("FAIL")

  println("------Problem 2------");

  val start = System.currentTimeMillis()
  print_result(Problem2.primes.nth(0) == Some((2, 2)))
  print_result(Problem2.primes.nth(2) == Some((5, 10)))
  val end = System.currentTimeMillis()

  println("Elapsed: " + (end - start) + " ms");
}
