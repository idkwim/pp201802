package pp201802.prob3.Test
import pp201802.prob3.Data._
import pp201802.prob3.Main._

object Test extends App {
  def print_result(b: Boolean): Unit =
    if (b) println("PASS") else println("FAIL")

  {
    implicit val intOrd: Ord[Int] = new Ord[Int] {
      def cmp(me: Int, you: Int) = me - you
    }
    implicit val charOrd: Ord[Char] = new Ord[Char] {
      def cmp(me: Char, you: Char) = me - you
    }

    def iterTest[D, A](l: List[A])(implicit dict: Dict[D, A, Int], iter: Iter[D, A]): List[A] = {
      def add(l: List[A]): D = l match {
        case Nil => dict.empty
        case hd::tl => dict.add(add(tl), hd, 1)
      }
      def getKeys(d: D): List[A] = {
        iter.getValue(d) match {
          case None => Nil
          case Some(k) => k::getKeys(iter.getNext(d))
        }
      }
      getKeys(add(l))
    }
    print_result(iterTest(List('x','d','a','b','d','b','a','v','d','c','b','d','a'))(Problem3.listDict[Char, Int], Problem3.listIter[Char, Int]) == List('a','b','c','d','v','x'))
    print_result(iterTest(List('x','d','a','b','d','b','a','v','d','c','b','d','a'))(Problem3.BSTDict[Char, Int], Problem3.BSTIter[Char, Int]) == List('a','b','c','d','v','x'))
  }
}

