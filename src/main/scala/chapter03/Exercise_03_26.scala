package chapter03

object Exercise_03_26 extends App {

  def maximum(tree: Tree[Int]): Int = tree match {
    case Leaf(v) => v
    case Branch(l, r) => maximum(l).max(maximum(r))
  }

  println(maximum(Leaf(1)))
  println(maximum(Branch(Branch(Leaf(1), Leaf(5)), Branch(Leaf(4), Leaf(3)))))
  println(maximum(Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(8), Branch(Leaf(9), Leaf(7))))))

}