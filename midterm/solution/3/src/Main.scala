package pp201802.midterm
import pp201802.midterm.Data._

object Main {

  def calculator(e: Exp): Int =
    e match {
      case EInt(n) => n
      case EOp(OpAdd(), e1, e2) => calculator(e1) + calculator(e2)
      case EOp(OpSub(), e1, e2) => calculator(e1) - calculator(e2)
      case EOp(OpMul(), e1, e2) => calculator(e1) * calculator(e2)
      case EError() => -1
    }

}
