package pp201802.midterm
import pp201802.midterm.Data._

/*
  Problem 3: Exp calculator (10 pt)
  Given an expression (Exp), calculate the result in Int value.
  EAdd, ESub, and EMul classes represents operators "+", "-", and "*",
  respectively.
  EError is an erroneous case, though, you don't have to consider such case in
  this problem.

  ex)
  calculator(EOp(OpAdd(), Eint(1), Eint(2))) = 3

  (*) Syntax of Exp (see Data.scala)
  Exp = n in Int
      | Op e1 e2
      | Error

  Op  = +
      | -
      | *
   
*/

object Main {

  def calculator(e: Exp): Int = ???

}
