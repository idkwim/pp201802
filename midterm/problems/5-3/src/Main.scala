package pp201802.midterm
import pp201802.midterm.Data._

/*
  Problem 5-3: Syntax Analysis - Parser (40 pt + bonus)
  Implement a function that converts a list of tokens to an expression (Exp).
  The result of calculating the converted Exp should be the same as the result
  of calculating the original expression in a list of characters.
  In this problem, integers, "+", "-", "*", "(", and ")" will be given as tokens.
  Note that the order of operations is as in common sense.

  ex)
  calculator(parser({TkInt(62), TkBop(OpSub()), TkInt(500), TkBop(OpAdd()), TkInt(4)})
    = 62 - 500 + 4 = -434
  calculator(parser({TkInt(62), TkBop(OpSub()), TkLPar(), TkInt(500), TkBop(OpAdd()), TkInt(4), TkRPar()})
    = 62 - (500 + 4) = -442
  calculator(parser({TkLPar(), TkInt(62), TkBop(OpSub()), TkInt(500), TkRPar(), TkBop(OpMul()), TkInt(4)})
    = (62 - 500) * 4 = -1752
  calculator(parser({TkInt(62), TkBop(OpSub()), TkInt(500), TkBop(OpMul()), TkInt(4)})
    = 62 - 500 * 4 = -1938
  
  (Caution)
  1. Parser must be able to handle gramatical errors of token lists.
     Note that the result of parsing an erroneous token list should be Error
     itself, rather than an expression containing Error.

     ex)
     3 3 + 4 => EError()
     (((3 + 4) => EError()


  (*) Tokens (see Data.scala)
  Token = n in Int (n >= 0)
        | (
        | )
        | Op

  Op    = +
        | -
        | *

  (*) Syntax of Exp (see Data.scala)
  Exp = n in Int
      | Op e1 e2
      | Error

  (*) "List" is an algebraic datatype which is defined as below.

    sealed abstract class List[A]
    case class Nil() extends List[A]
    case class Cons(hd: A, tl: List[A]) extends List[A]

  Scala provides a special syntax for List.
  - "Nil" means "Nil()", and
  - "hd :: tl" means "Cons(hd, tl)".

  For usage, see below "drop_two".

    def drop_two(l: List[Int]): List[Int] =
      l match {
        case hd1::tl1 =>
          tl1 match {
            case hd2::tl2 => tl2
            case Nil => Nil
          }
        case _ => Nil
      }
*/

object Main {

  def parser(l: List[Token]): Exp = ???

}
