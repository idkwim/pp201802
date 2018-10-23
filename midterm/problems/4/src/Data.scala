package pp201802.midterm.Data

sealed abstract class Bop
case class OpAdd() extends Bop
case class OpSub() extends Bop
case class OpMul() extends Bop

sealed abstract class Token
case class TkBop(o: Bop) extends Token
case class TkInt(n: Int) extends Token
case class TkLPar() extends Token
case class TkRPar() extends Token
