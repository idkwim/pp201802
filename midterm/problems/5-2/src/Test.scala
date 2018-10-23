package pp201802.midtermtest
import pp201802.midterm.Main._
import pp201802.midterm.Data._

object Test extends App {
  def print_result(b:Boolean) : Unit =
    if (b) println("O") else println("X")

  println("parser(List(TkInt(1), TkBop(OpSub()), TkInt(2), TkBop(OpSub()), TkInt(3))) is equal to " + parser(List(TkInt(1), TkBop(OpSub()), TkInt(2), TkBop(OpSub()), TkInt(3))))
  println("parser(List(TkInt(8), TkBop(OpSub()), TkLPar(), TkInt(9), TkBop(OpSub()), TkInt(3), TkRPar(), TkBop(OpSub()), TkInt(20))) is equal to " + parser(List(TkInt(8), TkBop(OpSub()), TkLPar(), TkInt(9), TkBop(OpSub()), TkInt(3), TkRPar(), TkBop(OpSub()), TkInt(20))))
  println("parser(List(TkLPar(), TkInt(8), TkBop(OpAdd()), TkInt(9), TkBop(OpSub()), TkInt(3), TkRPar(), TkBop(OpAdd()), TkLPar(), TkLPar(), TkInt(23), TkBop(OpAdd()), TkInt(2), TkRPar(), TkBop(OpSub()), TkInt(1), TkRPar())) is equal to " + parser(List(TkLPar(), TkInt(8), TkBop(OpAdd()), TkInt(9), TkBop(OpSub()), TkInt(3), TkRPar(), TkBop(OpAdd()), TkLPar(), TkLPar(), TkInt(23), TkBop(OpAdd()), TkInt(2), TkRPar(), TkBop(OpSub()), TkInt(1), TkRPar())))
  println("parser(List(TkLPar(), TkLPar(), TkInt(3), TkBop(OpSub()), TkInt(2), TkRPar())) is equal to " + parser(List(TkLPar(), TkLPar(), TkInt(3), TkBop(OpSub()), TkInt(2), TkRPar())))
}
