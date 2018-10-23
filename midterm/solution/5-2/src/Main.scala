package pp201802.midterm
import pp201802.midterm.Data._

object Main {

  def measureOp(o: Bop) : Int =
    o match {
      case OpAdd() => 10
      case OpSub() => 10
      case OpMul() => 20
    }

  def op_parser(n: Int, e: Exp, l: List[Token]): (Exp, List[Token]) =
    l match {
      case TkBop(o)::tl if(n < measureOp(o) && e != EError()) =>
        term_parser(measureOp(o), tl) match {
          case (e1, tl1) if(e1 != EError()) => op_parser(n, EOp(o, e, e1), tl1)
          case _ => (EError(), Nil)
        }
      case _ => (e, l)
    }

  def term_parser(n: Int, l: List[Token]): (Exp, List[Token]) = {
    val (e, l1) =
      l match {
        case TkInt(m)::tl => (EInt(m), tl)
        case TkLPar()::tl =>
          term_parser(0, tl) match {
            case (e1, TkRPar()::tl1) if(e1 != EError()) => (e1, tl1)
            case _ => (EError(), Nil)
          }
        case _ => (EError(), Nil)
      }
    op_parser(n, e, l1)
  }

  def parser(l: List[Token]): Exp = {
    term_parser(0, l) match {
      case (e, Nil) => e
      case _ => EError()
    }
  }

}
