package pp201802.prob1
import pp201802.prob1.Data.DataBundle._

object Main {

  /* Problem 1
   *
   * Define typeclasses for real numbers, complex numbers, and polynomials.
   * Implement a function eval that evaluates polynomial with parameter x.
   *
   * A complex number consists of real part and imaginary part.
   * e.g. Complex(a, b) represents a + bi.
   *
   * Operations on complex numbers are defined as following.
   * Complex(a, b) + Complex(c, d) = Complex(a + c, b + d)
   * Complex(a, b) * Complex(c, d) = Complex(ac - bd, ad + bc)
   *
   * A polynomial is defined as a list of type A, where type A is the type of
   * the coefficients.
   * e.g. (1, 2, 3): Poly[Real] represents 1 + 2 * x + 3 * x^2
   *
   * eval(coeffs, x) evaluates f(x) where coeffs represents a polynomial f.
   * e.g. eval((1, 2, 3), 2) = 1 + 2 * 2 + 3 * 2^2 = 17
   *
   */

  object Problem1 {
    implicit def realAddProxy: AddOp[Real] = ???

    implicit def realMultProxy: MultOp[Real] = ???

    implicit def complexAddProxy: AddOp[Complex] = ???

    implicit def complexMultProxy: MultOp[Complex] = ???

    implicit def polyAddProxy[A](implicit addProxy: AddOp[A], multProxy: MultOp[A]): AddOp[Poly[A]] = ???

    implicit def polyMultProxy[A](implicit addProxy: AddOp[A], multProxy: MultOp[A]): MultOp[Poly[A]] = ???

    def eval[A](coeffs: Poly[A], x: A)(implicit addProxy: AddOp[A], multProxy: MultOp[A]) : A = ???
  }
}
