package pp201802.midterm
import pp201802.midterm.Data._

/*
  Problem 4: Lexical Analysis - Lexer (20 pt)
  Implement a function that converts a list of characters into a list of Tokens.
  There are 6 kinds of tokens, which are integers, "+", "-", "*", "(", and ")".
  
  ex) Lexer({'6', '2', '+', '5', '0', '0'}) => {TkInt(62), TkBop(OpAdd()), TkInt(500)}
      Lexer({'(', '6', '2', '+', '5', '0', '0', ')', '-', '4'}) => {TkLPar(), TkInt(62), TkBop(OpAdd()), TkInt(500), TkRPar(), TkBop(OpSub()), TkInt(4)}

  (Caution)
  1. Whitespaces separate tokens.

     ex)
     33 => TkInt(33)
     3 3 => TkInt(3) TkInt(3)
     
  2. Only '0' ~ '9', '+', '-', '*', '(', ')', and ' ' will be given as an input.

  3. Lexer does not check the grammar.

     ex)
     3 3 + 4 => TkInt(3) TkInt(3) TkBop(OpAdd()) TkInt(4)
     (((3 + 4) => TkLPar() TkLPar() TkLPar() TkInt(3) TkBop(OpAdd()) TkInt(4) TkRPar()

  4. There is no unary operator.

     ex)
     -5 => TkBop(OpSub()) TkInt(5)

  (*) Tokens (see Data.scala)
  Token = n in Int (n >= 0)
        | (
        | )
        | Op

  Op    = +
        | -
        | *

  (*) type "Char" consists characters such as '7', 'a', '(', ...
  For usage, see below "char_to_int".

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

  /* returns the corresponding integer.
  returns -1 if the input is not a digit. */
  def char_to_int(c: Char): Int =
    c match {
      case '0' => 0
      case '1' => 1
      case '2' => 2
      case '3' => 3
      case '4' => 4
      case '5' => 5
      case '6' => 6
      case '7' => 7
      case '8' => 8
      case '9' => 9
      case _ => -1
    }

  def lexer(l: List[Char]): List[Token] = ???

}
