package pp201802.prob2.Data
import scala.annotation.tailrec

abstract class LazyList[A] {
  def head: Option[A]
  def tail: LazyList[A]
  def nth(n: Int): Option[A] = LazyList.nth(this, n)
}

object LazyList {
  @tailrec def nth[A](l: LazyList[A], n: Int): Option[A] =
    l.head match {
      case None => None
      case Some(hd) => if (n <= 0) Some(hd) else nth(l.tail, n-1)
    }
}

case class LNil[A]() extends LazyList[A] {
  val head = None
  val tail = this
}

class LCons[A](hdtl: =>(A, LazyList[A])) extends LazyList[A] {
  lazy val (hd,tl) = hdtl
  def head = Some(hd)
  def tail = tl
}

object LCons {
  def apply[A](hdtl: =>(A,LazyList[A])) = new LCons(hdtl)
}
