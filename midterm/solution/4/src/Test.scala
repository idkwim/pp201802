package pp201802.midtermtest
import pp201802.midterm.Main._
import pp201802.midterm.Data._

object Test extends App {
  def print_result(b:Boolean) : Unit =
    if (b) println("O") else println("X")

  print_result(lexer("(42)".toList) == List(TkLPar(), TkInt(42), TkRPar()))
  print_result(lexer("62+500".toList) == List(TkInt(62), TkBop(OpAdd()), TkInt(500)))
  print_result(lexer("(81310-2422)*(13-421-4)".toList) == List(TkLPar(), TkInt(81310), TkBop(OpSub()), TkInt(2422), TkRPar(), TkBop(OpMul()), TkLPar(), TkInt(13), TkBop(OpSub()), TkInt(421), TkBop(OpSub()), TkInt(4), TkRPar()))

}
