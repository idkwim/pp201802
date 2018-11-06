package pp201802.hw2
import pp201802.hw2.Data._
import pp201802.hw2.Data.DataBundle._

object Main {
  /*
   Implement given functions, which is currently blank. (???)
   */

  /*
   Exercise 1: Zip up two lists
   Zips up two lists into one, alternating between elements
   taken from the first list and elements from the second.
   ex)
   zip of {3, 2, 1} and {4, 5} is equal to {3, 4, 2, 5, 1}.
   zip of {1, 8} and {9, 2, 4, 7} is eqaul to {1, 9, 8, 2, 4, 7}.  
   */

  def zip(l1: IList, l2:IList): IList =
    l1 match {
      case INil() => l2
      case ICons(h1, t1) =>
        l2 match {
	  case ICons(h2, t2) => ICons(h1, ICons(h2, zip (t1, t2)))
	  case INil() => l1
      	}
    }

  /*
   Exercise 2: Exp calculator with sqrt
   Given Exp, calculate the result of Int value.
   For each case class EAdd/ESub/EMul, you may interpret them as
   normal integer operators: +, -, *.
   For each case class ESqr, you should calculate the square of
   the operand
   */

  def calculate(x : Exp) : Int =
    x match {
      case EInt(n) => n
      case EAdd(e1, e2) => calculate(e1) + calculate(e2)
      case ESub(e1, e2) => calculate(e1) - calculate(e2)
      case EMul(e1, e2) => calculate(e1) * calculate(e2)
      case ESqr(e1) => calculate(e1) * calculate(e1)
    }

  /*
   Exercise 3: Bubble sort with Polymorphism
   Implement the bubble sort (https://en.wikipedia.org/wiki/Bubble_sort).
   The output should be a reordering of the input in nondecreasing order.

   Each time, comparator(cmp) will be given as an argument.
   The result of cmp(k1, k2) should be interpreted as the following:
     negative: k1 < k2
     zero:     k1 == k2
     positive: k1 > k2
   */

  def sort[A](l: MyList[A])(cmp: A => A => Int): MyList[A] = {
    def bubble(l: MyList[A]): MyList[A] =
      l match {
        case MyNil() => l
        case MyCons(x, t1) =>
          bubble(t1) match {
            case MyNil() => l
            case MyCons(y, t2) =>
              cmp(x)(y) match {
                case n if n < 0 => MyCons(x, MyCons(y, t2))
                case _ => MyCons(y, MyCons(x, t2))
              }
          }
      }

    def _sort(l: MyList[A]): MyList[A] =
      l match {
        case MyNil() => l
        case MyCons(_, _) => 
          bubble(l) match {
            case MyNil() => l
            case MyCons(hd, tl) => MyCons(hd, _sort(tl))
          }
      }

    _sort(l)
  }
     
  /*
   Exercise 4: Tree traversal
   Implement preorder, inorder, postorder tree traversals.
   (https://en.wikipedia.org/wiki/Tree_traversal)
   */

  def append[A](l1: MyList[A], l2: MyList[A]): MyList[A] =
    l1 match {
      case MyNil() => l2
      case MyCons(h1, t1) => MyCons(h1, append(t1, l2))
    }

  def preorder[A](tree: BTree[A]): MyList[A] =
    tree match {
      case Leaf() => MyNil[A]
      case Node(x, l, r) => MyCons(x, append(preorder(l), preorder(r)))
    }

  def inorder[A](tree: BTree[A]): MyList[A] =
    tree match {
      case Leaf() => MyNil[A]
      case Node(x, l, r) => append(inorder(l), MyCons(x, inorder(r)))
    }

  def postorder[A](tree: BTree[A]): MyList[A] =
    tree match {
      case Leaf() => MyNil[A]
      case Node(x, l, r) => append(append(postorder(l), postorder(r)), MyCons(x, MyNil()))
    }
}
