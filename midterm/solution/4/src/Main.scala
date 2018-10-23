package pp201802.midterm
import pp201802.midterm.Data._

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

  def intlexer(n: Int, l: List[Char]): (Int, List[Char]) =
    l match {
      case hd::tl if(char_to_int(hd) >= 0) =>
        intlexer(10 * n + char_to_int(hd), tl)
      case _ => (n, l)
    }

  def lexer(l: List[Char]): List[Token] =
    l match {
      case hd::tl =>
        hd match {
          case '(' => TkLPar()::lexer(tl)
          case ')' => TkRPar()::lexer(tl)
          case '+' => TkBop(OpAdd())::lexer(tl)
          case '-' => TkBop(OpSub())::lexer(tl)
          case '*' => TkBop(OpMul())::lexer(tl)
          case ' ' => lexer(tl)
          case _ if (char_to_int(hd) >= 0) => {
            val (n1, tl1) = intlexer(char_to_int(hd), tl)
            TkInt(n1)::lexer(tl1)
          }
        }
      case _ => Nil
    }

}
