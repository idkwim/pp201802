package pp201802.midtermtest
import pp201802.midterm.Main._

object Test extends App {
  def print_result(b:Boolean) : Unit =
    if (b) println("O") else println("X")

  print_result(fib(3) == 3)
}
