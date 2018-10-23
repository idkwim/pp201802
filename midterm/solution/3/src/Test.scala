package pp201802.midtermtest
import pp201802.midterm.Main._
import pp201802.midterm.Data._

object Test extends App {
  def print_result(b:Boolean) : Unit =
    if (b) println("O") else println("X")

  print_result(calculator(EOp(OpSub(),EInt(62),EInt(500))) == -438)
  print_result(calculator(EOp(OpSub(),EInt(5),EOp(OpMul(),EInt(8),EInt(3)))) == -19)
  print_result(calculator(EOp(OpAdd(),EOp(OpAdd(),EInt(3),EInt(88)),EOp(OpAdd(),EOp(OpAdd(),EInt(22),EOp(OpMul(),EInt(2),EInt(6))),EInt(7)))) == 132)
      
}
