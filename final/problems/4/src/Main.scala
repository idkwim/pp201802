package pp201802.prob4
import scala.language.higherKinds
import scala.language.implicitConversions
import pp201802.prob4.Data._

object Main {

  /* Problem 4
   *
   * Modify three classes Rectangle, Circle, and Triangle, so that Test.scala
   * can be compilable.
   * Implement a function SumOfArea, which computes the sum of area of l's
   * elements.
   * See Test.scala for the form of inputs that will be given.
   *
   * Note that the class names and the types of the parameters to the
   * constructors should be maintained.
   *
   */

  object Problem4 {
    class Rectangle(width: Double, height: Double) {
      val area: Double = width * height
    }

    class Circle(radius: Double) {
      val area: Double = 3.14 * radius * radius
    }

    class Triangle(width: Double, height: Double) {
      val area: Double = width * height / 2
    }

    def SumOfArea(l: List[Shape]): Double = ???
  }
}
