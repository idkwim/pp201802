package pp201802.hw3
import pp201802.hw3.Data.DataBundle._
import scala.annotation.tailrec

object Main {
  /* Problem 1: Structural Sub Type
   Complete the definition of MyClass
   DO NOT USE "Any" in anywhere in your code.
   */
  object Problem1{
    class MyClass[A,B,C,D,E,F]() {
      type Func1 = { val a: A } => { val b: B }
      type Func2 = { val b: B } => { val a: A }

      type Ty1 = {
        def apply: { val func: Func1 ; val c: C } => { val b: B ; val d: D }
        val a: A
        val b: B
      }

      type Ty2 = {
        def apply: { val func: Func2 ; val e: E } => { val b: B ; val f: F }
        val a: A
        val c: C
      }

      /*
       Find suitable common supertype of Ty1 and Ty2,
       and replace "Any" with that type.
       */
      // type CommonTy = Any // Any

      type CommonTy = {
        def apply: { val func: {} => {val a:A; val b:B}; val c:C; val e:E} => {val b:B}
        val a: A
      }
    }
  }

  /* Problem 2
   Complete an implementation of 'IterDict'.
   IterDict represents a dictionary type.
   (See https://en.wikipedia.org/wiki/Associative_array for more information.)
   Briefly, you can store (key, value) pair into a dictionary,
   and search the stored value later from the associated key value.
   Here, your dictionary should be properly iterable.
   */
  object Problem2 {
    object IterDictImpl {
      //Write empty IterDict
      def empty[K, V](eqFunc: K => K => Boolean): IterDict[K, V] =
        new IterDictImpl(eqFunc)(Nil)
    }

    // object IterDictImpl {
    //   //Write empty IterDict
    //   def empty[K, V](eqFunc: K => K => Boolean): IterDictImpl[K, V] = ??? // null
    // }

    class IterDictImpl[K, V](eqFunc: K => K => Boolean)(val data: List[(K, V)])
        extends IterDict[K, V] {

      def getValue =
        data match {
          case Nil => None
          case h::t => Some(h)
        }

      def getNext =
        data match {
          case Nil => IterDictImpl.empty[K, V](eqFunc)
          case h::t => new IterDictImpl[K, V](eqFunc)(t)
        }

      // When the given key already exists in this dictionary, overwrite the value.
      def add(k: K, v: V) : IterDict[K, V] = {
        def go(l:List[(K, V)]):List[(K, V)] =
          l match {
            case Nil => (k, v)::Nil
            case h::t => if (h._1 == k) (k, v)::t else h::go(t)
          }
        new IterDictImpl(eqFunc)(go(data))
      }

      // Return the associated value with the key. When there is no such key, return None.
      def find(k: K) : Option[V] = {
        def _find(i:Iter[(K, V)]):Option[V] =
          i.getValue match {
            case None => None
            case Some(h) => if (h._1 == k) Some(h._2) else _find(i.getNext)
          }
        _find(this)
      }
    }

    // Write a function that iterates through given iterator and sum it.
    def sumElements[K](xs: Iter[(K, Int)]): Int =
      xs.getValue match {
        case None => 0
        case Some(h) => h._2 + sumElements(xs.getNext)
      }

      /*
      def getValue = ??? // None

      def getNext = ??? // null

      // When the given key already exists in this dictionary, overwrite the value.
      def add(k: K, v: V) : IterDict[K, V] = ??? // null

      // Return the associated value with the key. When there is no such key, return None.
      def find(k: K) : Option[V] = ??? // None
    }

    // Write a function that iterates through given iterator and sum it.
    def sumElements[K](xs: Iter[(K, Int)]): Int = ??? // 0
       */
  }

  /* Problem 3
   Define 'BiIterable' list and tree classes.
   These should provide bi-directional iteration, so you can freely move
   the iterator forward(getNext) or backward(getPrev) at any moment.
   For a BiIterableTree, the iterator should first visit the root, and then
   visit all nodes in the left subtree, and finally visit all nodes in the
   right subtree.
   (See preordering in https://en.wikipedia.org/wiki/Depth-first_search
   for more information.)
   At each end, your BiIter cannot go further, but should be able to go back
   to the reversed direction.
   For example:
   When you are on the first element,
   - getPrev.getValue gives None.
   - getPrev.getPrev.getValue also gives None.
   - getPrev.getPrev.getPrev.getPrev.getNext.getValue gives Some(first-element)
   Similarly, when you are on the last element,
   - getNext.getValue gives None.
   - getNext.getNext.getValue also gives None.
   - getNext.getNext.getNext.getNext.getPrev.getValue gives Some(last-element)
   You may create your own classes for this exercise.
   */
  object Problem3 {

    class MyBiIterImpl[A](val prev:List[A], val cur:Option[A], val next:List[A]) extends BiIter[A] {
      def getValue = cur
      def getNext: BiIter[A] = {
        val prev_n =
          cur match {
            case None => prev
            case Some(c) => c::prev
          }
        next match {
          case Nil => new MyBiIterImpl[A](prev_n, None, Nil)
          case h::t => new MyBiIterImpl[A](prev_n, Some (h), t)
        }
      }

      def getPrev: BiIter[A] = {
        val next_n =
          cur match {
            case None => next
            case Some(c) => c::next
          }
        prev match {
          case Nil => new MyBiIterImpl[A](Nil, None, next_n)
          case h::t => new MyBiIterImpl[A](t, Some (h), next_n)
        }
      }
    }
    object MyBiIterImpl {
      // works only when l and r are on the first element
      def toList[A](i:MyBiIterImpl[A]):List[A] = {
        val cur_l =
          i.cur match {
            case None => Nil
            case Some(a) => a::Nil
          }
        i.prev ++ cur_l ++ i.next
      }

      // def merge[A](l:MyBiIterImpl[A], r:MyBiIterImpl[A]): MyBiIterImpl[A] =
      //   (toList(l) ++ toList(r)) match {
      //     case Nil => new MyBiIterImpl(Nil, None, Nil)
      //     case h::t => new MyBiIterImpl(Nil, Some(h), t)
      //   }
    }

    class BiIterableList[A](val data: List[A]) extends BiIterable[A] {
      def biIter: BiIter[A] =
        data match {
          case Nil => new MyBiIterImpl(Nil, None, Nil)
          case h::t => new MyBiIterImpl(Nil, Some(h), t)
        }
    }

    sealed abstract class BiIterableTree[A] extends BiIterable[A] {
      // You can write something here
      def biIter : MyBiIterImpl[A]
    }

    case class Empty[A]() extends BiIterableTree[A] {
      def biIter = new MyBiIterImpl(Nil, None, Nil)
    }

    case class Node[A](value: A, left: BiIterableTree[A], right: BiIterableTree[A])
        extends BiIterableTree[A] {
      def biIter = new MyBiIterImpl(Nil, Some(value),
        MyBiIterImpl.toList(left.biIter) ++ MyBiIterImpl.toList(right.biIter))
    }
  }

    /*
   class BiIterableList[A](val data: List[A]) extends BiIterable[A] {
      def biIter: BiIter[A] = ??? // null
    }

    sealed abstract class BiIterableTree[A] extends BiIterable[A] {
      // You can write something here
    }

    case class Empty[A]() extends BiIterableTree[A] {
      def biIter = ??? // null
    }

    case class Node[A](value: A, left: BiIterableTree[A], right: BiIterableTree[A])
        extends BiIterableTree[A] {
      def biIter = ??? // null
    }
  }
     */

  /* Problem 4
   Define 'BiIterable' list and tree classes.
   These should provide bi-directional iteration, so you can freely move
   the iterator forward(getNext) or backward(getPrev) at any moment.
   For a BiIterableTree, the iterator should first visit the root, and then
   visit all nodes in the left subtree, and finally visit all nodes in the
   right subtree.
   */
  object Problem4 {
    val primes : LazyList[Int] = {
      lazy val oddPrimes = go(0,3)
      @tailrec def indivisible(prms: LazyList[Int], i: Int, n: Int) : Boolean =
        if (i <= 0) true else prms.head match {
          case None => throw new Exception("...")
          case Some(p) => if (n%p == 0) false else indivisible(prms.tail, i-1, n)
        }
      @tailrec def computeNext(i: Int, n: Int) : Int =
        if (indivisible(oddPrimes, i, n)) n
        else computeNext(i, n + 2)
      def go(i: Int, n: Int): LazyList[Int] =
        LCons({
          val nextPrime = computeNext(i,n)
          (nextPrime, go(i+1,nextPrime+2))
        })
      LCons(2, oddPrimes)
    }
  }

}
