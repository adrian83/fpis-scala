package chapter03

object Exercise_03_28 extends App {

  def map[A, B](tree: Tree[A])(f: A => B): Tree[B] = tree match {
    case Leaf(a) => Leaf(f(a))
    case Branch(l, r) => Branch(map(l)(f), map(r)(f))
  }

  println(map(Leaf(1))(2 * _))
  println(map(Branch(Branch(Leaf(1), Leaf(5)), Branch(Leaf(4), Leaf(3))))(2 * _))
  println(map(Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(8), Branch(Leaf(9), Leaf(7)))))(2 * _))

}