package pp201802.prob5
import scala.language.higherKinds
import scala.language.implicitConversions
import pp201802.prob5.Data._

object Main {

  /* Problem 5
   *
   * Define MyT, so that Test.scala can be compilable.
   * Implement a function SumOfArea, which computes the sum of area of l's
   * elements regardless of their types (Rectangle, Circle, and Triangle).
   * See Test.scala for the form of inputs that will be given.
   *
   * Note that you should never modify Data.scala or Test.scala.
   *
   * Hint: Use typeclasses.
   *
   */

  object Problem5 {
    type MyT = ???

    def SumOfArea(l: List[MyT]): Double = ???
  }
}
