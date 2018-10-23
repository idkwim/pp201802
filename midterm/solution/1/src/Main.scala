package pp201802.midterm
import scala.annotation.tailrec

object Main {
  
  def fib(n: Int): BigInt = {
    @tailrec
    def _fib(idx: Int, current: BigInt, past: BigInt): BigInt =
      if(idx == n) current
      else _fib(idx + 1, past + current, current)
    _fib(0, 1, 0)
  }

}
