package pp201802.prob2
import pp201802.prob2.Data._
import scala.annotation.tailrec

object Main {

  /* Problem 2
   *
   * Define an infinite lazy list of prime numbers and their summations.
   * The value primes should be a lazy list, where i-th tuple is
   * (i-th prime number, sum of all the first to the i-th prime numbers).
   * It should compute infinitely many primes *lazily*, which means that it
   * computes each prime whenever it needs.
   * Finding the 20000th element should be completed in 5 secs and finding the
   * 100th element should be completed in 0.1 secs.
   *
   * Hint: You may have to use tail recursion and "lazy val".
   * NOTE: DO NOT pre-calculate the elements of the list.
   *
   */

  object Problem2 {
    val primes: LazyList[(Int, Int)] = ???
  }
}
