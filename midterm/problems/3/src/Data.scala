package pp201802.midterm.Data

sealed abstract class Bop
case class OpAdd() extends Bop
case class OpSub() extends Bop
case class OpMul() extends Bop

sealed abstract class Exp
case class EInt(i: Int) extends Exp
case class EOp(o: Bop, lhs: Exp, rhs: Exp) extends Exp
case class EError() extends Exp
