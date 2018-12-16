package pp201802.prob1.Data

object DataBundle {
  type Real = Double

  class Complex(val real: Real, val imaginary: Real)

  type Poly[A] = List[A]

  /*
  Typeclass defining add operator.
  Instance of this typeclass should satisfy the following laws:
  Identity: for all element a of type A, op(identity, a) = a
  Inverse: for all element a of type A, op(a, inverse(a)) = identity
  */
  abstract class AddOp[A] {
    def op(a: A, b: A): A
    val identity: A
    def inverse(a: A): A
  }

  /*
  Typeclass defining multiply operator.
  Instance of this typeclass should satisfy the following laws:
  Identity: for all element a of type A, op(identity, a) = a
  */
  abstract class MultOp[A] {
    def op(a: A, b: A): A
    val identity: A
  }
}
