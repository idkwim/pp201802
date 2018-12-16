package pp201802.prob3
import pp201802.prob3.Data._
import scala.annotation.tailrec

object Main {

  /* Problem 3
   *
   * Implement two versions of Dict and Iter using a list and a BST (binary
   * search tree, see bst.pdf).
   * Dict should be able to add, lookup, and remove an element.
   * Iter must iterate through a dictionary in ascending order of keys.
   *
   * Note that BST structure of BSTDict should be preserved after each
   * operation (add, lookup, and remove).
   *
   */

  object Problem3 {
    implicit def listDict[K, V](implicit ord: Ord[K]): Dict[List[(K, V)], K, V] = ???

    implicit def listIter[K, V]: Iter[List[(K, V)], K] = ???

    implicit def BSTDict[K, V](implicit ord: Ord[K]): Dict[BST[K, V], K, V] = ???

    implicit def BSTIter[K, V]: Iter[BST[K, V], K] = ???
  }
}
