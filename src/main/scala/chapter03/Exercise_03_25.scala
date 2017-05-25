package chapter03

object Exercise_03_25 extends App {

  def size[A](tree: Tree[A]): Int = tree match {
    case Leaf(_) => 1
    case Branch(l, r) => 1 + size(l) + size(r)
  }

  println(size(Leaf(1)))
  println(size(Branch(Branch(Leaf(1), Leaf(1)), Branch(Leaf(1), Leaf(1)))))
  println(size(Branch(Branch(Leaf(1), Leaf(1)), Branch(Leaf(1), Branch(Leaf(1), Leaf(1))))))

}