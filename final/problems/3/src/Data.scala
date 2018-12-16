package pp201802.prob3.Data

sealed abstract class BST[K, V]
case class Leaf[K, V]() extends BST[K, V]
case class Node[K, V](key: K, value: V, left: BST[K, V], right: BST[K, V]) extends BST[K, V]

abstract class Iter[I, A] {
  def getValue(i: I): Option[A]
  def getNext(i: I): I
}

abstract class Ord[A] {
  def cmp(me: A, you: A): Int
  def ===(me: A, you: A): Boolean = cmp(me, you) == 0
  def <(me: A, you: A): Boolean = cmp(me, you) < 0
  def >(me: A, you: A): Boolean = cmp(me, you) > 0
  def <=(me: A, you: A): Boolean = cmp(me, you) <= 0
  def >=(me: A, you: A): Boolean = cmp(me, you) >= 0
}

abstract class Dict[D, K, V] {
  val empty: D
  def add(x: D, k: K, v: V): D
  def lookup(x: D, k: K): Option[V]
  def remove(x: D, k: K): (D, Option[V])
}
