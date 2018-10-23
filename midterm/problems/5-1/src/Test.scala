package pp201802.midtermtest
import pp201802.midterm.Main._
import pp201802.midterm.Data._

object Test extends App {
  def print_result(b:Boolean) : Unit =
    if (b) println("O") else println("X")

  println("parser(List(TkInt(133))) is equal to " + parser(List(TkInt(133))))
  println("parser(List(TkInt(5), TkBop(OpAdd()), TkBop(OpAdd()), TkInt(3))) is equal to " + parser(List(TkInt(5), TkBop(OpAdd()), TkBop(OpAdd()), TkInt(3))))
  println("parser(List(TkInt(64), TkBop(OpAdd()), TkInt(21), TkBop(OpAdd()), TkInt(234))) is equal to " + parser(List(TkInt(64), TkBop(OpAdd()), TkInt(21), TkBop(OpAdd()), TkInt(234))))
}
