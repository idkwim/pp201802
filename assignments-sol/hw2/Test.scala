package pp201802.hw2test
import pp201802.hw2.Main._
import pp201802.hw2.Data._
import pp201802.hw2.Data.DataBundle._

object Test extends App {
  def print_result(b:Boolean) : Unit =
    if (b) println("O") else println("X")

  def listIntToIList(xs: List[Int]): IList =
    xs match {
      case (h :: t) => ICons(h, listIntToIList(t))
      case Nil => INil()
    }
    
  def listToMyList[A](xs: List[A]): MyList[A] =
    xs match {
      case (h :: t) => MyCons(h, listToMyList(t))
      case Nil => MyNil()
    }
    
  // Problem 1
  {
    val a = listIntToIList(List(1,3,5))
    val b = listIntToIList(List(2,4,6,7,8))
    val c = listIntToIList(List(1,2,3,4,5,6,7,8))

    print_result(zip(a,b) == c)
    print_result(zip(listIntToIList(List()), listIntToIList(List(15,167,2,8,3))) == listIntToIList(List(15,167,2,8,3)))
    print_result(zip(listIntToIList(List(124,12,6,1,7)), listIntToIList(List(15,167,2,8,3))) == listIntToIList(List(124,15,12,167,6,2,1,8,7,3)))
    print_result(zip(listIntToIList(List(124,12,6,1,7)), listIntToIList(List())) == listIntToIList(List(124,12,6,1,7)))
    print_result(zip(listIntToIList(List(124,12,6,1,7)), listIntToIList(List(15,8,3))) == listIntToIList(List(124,15,12,8,6,3,1,7)))
    print_result(zip(listIntToIList(List(124,12,6)), listIntToIList(List(15,167,2,8,3))) == listIntToIList(List(124,15,12,167,6,2,8,3)))
  }

  // Problem 2
  {
    val three = EInt(3)
    val two = EInt(2)
    val nine = EInt(9)
    val mone = EInt(-1)
    val mfive = EInt(-5)

    val add_two_mfive = EAdd(two, mfive)
    val add_add_two_mfive_three = EAdd(add_two_mfive, three)
    val sub_two_mfive = ESub(two, mfive)
    val mul_three_mfive = EMul(three, mfive)
    val sqr_nine = ESqr(nine)

    val mul_two_add_two_mfive = EMul(two, add_two_mfive)
    val sub_mul_three_mfive_add_two_mfive = EMul(mul_three_mfive, add_two_mfive)

    val mul_sub_mul_three_mfive_add_two_mfive_mfive = EMul(sub_mul_three_mfive_add_two_mfive, mfive)
    val mul_sqr_nine_sub_two_mfive = EMul(sqr_nine, sub_two_mfive)
    
    print_result(calculate(EAdd(two, three)) == 5)
    print_result(calculate(mone) == -1)
    print_result(calculate(add_two_mfive) == -3)
    print_result(calculate(sub_two_mfive) == 7)
    print_result(calculate(mul_three_mfive) == -15)
    print_result(calculate(sqr_nine) == 81)
    print_result(calculate(mul_two_add_two_mfive) == -6)
    print_result(calculate(sub_mul_three_mfive_add_two_mfive) == 45)
    print_result(calculate(mul_sub_mul_three_mfive_add_two_mfive_mfive) == -225)
    print_result(calculate(add_add_two_mfive_three) == 0)
    print_result(calculate(mul_sqr_nine_sub_two_mfive) == 567)
    print_result(calculate(ESqr(EMul(mfive, mfive))) == 625)
  }

  // Problem 3
  {
    val int_cmp = (scala.math.Ordering.Int.compare _).curried
    def rev_int_cmp(a:Int)(b:Int):Int = int_cmp(b)(a)
    val char_cmp = (scala.math.Ordering.Char.compare _).curried
    val string_cmp = (scala.math.Ordering.String.compare _).curried

    print_result(sort(listToMyList(List(6,4,2,4,1)))(int_cmp) == listToMyList(List(1,2,4,4,6)))
    print_result(sort(listToMyList(List(38,13,8,487,1,8,6)))(int_cmp) == listToMyList(List(1,6,8,8,13,38,487)))
    print_result(sort(listToMyList(List(6,4,2,4,1)))(rev_int_cmp) == listToMyList(List(6,4,4,2,1)))
    print_result(sort(listToMyList(List('d','a','b','x','k')))(char_cmp) == listToMyList(List('a','b','d','k','x')))
    print_result(sort(listToMyList(List('1','g','z','&','\n',' ')))(char_cmp) == listToMyList(List('\n',' ','&','1','g','z')))
    print_result(sort(listToMyList(List("Scala","is","fun")))(string_cmp) == listToMyList(List("Scala","fun","is")))
  }
  

  // Problem 4
  {
    val LeafI = Leaf[Int]()
    var LeafC = Leaf[Char]()
    var LeafS = Leaf[String]()

    val a = Node(1, Node(2, LeafI, Node(3, LeafI, LeafI)), Node(4, LeafI, Node(5, LeafI, LeafI)))
    val b = listToMyList(List(1,2,3,4,5))
    val c = listToMyList(List(2,3,1,4,5))
    val d = listToMyList(List(3,2,5,4,1))
    val x: BTree[Char] = Node('a', Node('b', Node('c', LeafC, Node('d', Node('e', LeafC, LeafC), LeafC)), Node('f', LeafC, Node('g', LeafC, LeafC))), Node('h', LeafC, Node('i', LeafC, LeafC)))
    val y: BTree[String] = Node("the", Node("is", Node("beginning", Node("The", LeafS, LeafS), LeafS), Node("half", LeafS, Node("of", LeafS, LeafS))), Node("whole", LeafS, LeafS))

    print_result(preorder(a) == b)
    print_result(inorder(a) == c)
    print_result(postorder(a) == d)
    print_result(preorder(x) == listToMyList(List('a','b','c','d','e','f','g','h','i')))
    print_result(inorder(x) == listToMyList(List('c','e','d','b','f','g','a','h','i')))
    print_result(postorder(x) == listToMyList(List('e','d','c','g','f','b','i','h','a')))
    print_result(preorder(y) == listToMyList(List("the","is","beginning","The","half","of","whole")))
    print_result(inorder(y) == listToMyList(List("The","beginning","is","half","of","the","whole")))
    print_result(postorder(y) == listToMyList(List("The","beginning","of","half","is","whole","the")))
  }
}
