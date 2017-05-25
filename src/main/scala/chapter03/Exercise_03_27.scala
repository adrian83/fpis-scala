package chapter03

object Exercise_03_27 extends App {

  def depth[A](tree: Tree[A]): Int = tree match {
    case Leaf(_) => 1
    case Branch(l, r) => 1 + depth(l).max(depth(r))
  }

  println(depth(Leaf(1)))
  println(depth(Branch(Branch(Leaf(1), Leaf(5)), Branch(Leaf(4), Leaf(3)))))
  println(depth(Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(8), Branch(Leaf(9), Leaf(7))))))

}