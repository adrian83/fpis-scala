package chapter03

object Exercise_03_29 extends App {

  def fold[A, B](tree: Tree[A])(start: B)(f: (B, Either[Leaf[A], Branch[A]]) => B): B = {
    tree match {
      case Leaf(a) => f(start, Left(Leaf(a)))
      case Branch(l, r) => f(start, Right(Branch(l, r)))
    }
  }

  
  def size[A](tree: Tree[A]): Int = fold(tree)(0)((s, t) => t match {
    case Left(l) => 1
    case Right(Branch(l, r)) => 1 + size(l) + size(r)
  })

  println(size(Leaf(1)))
  println(size(Branch(Branch(Leaf(1), Leaf(5)), Branch(Leaf(4), Leaf(3)))))
  println(size(Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(8), Branch(Leaf(9), Leaf(7))))))

  
  def maximum(tree: Tree[Int]): Int = fold(tree)(Int.MinValue)((s, t) => s.max(t match {
    case Left(Leaf(a)) => a
    case Right(Branch(l, r)) => maximum(l).max(maximum(r))
  }))

  println(maximum(Leaf(1)))
  println(maximum(Branch(Branch(Leaf(1), Leaf(5)), Branch(Leaf(4), Leaf(3)))))
  println(maximum(Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(8), Branch(Leaf(9), Leaf(7))))))

  
  def depth(tree: Tree[Int]): Int = fold(tree)(0)((s, t) => s + (t match {
    case Left(Leaf(a)) => 1
    case Right(Branch(l, r)) => 1 + depth(l).max(depth(r))
  }))

  println(depth(Leaf(1)))
  println(depth(Branch(Branch(Leaf(1), Leaf(5)), Branch(Leaf(4), Leaf(3)))))
  println(depth(Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(8), Branch(Leaf(9), Leaf(7))))))

  
  def map[A, B](tree: Tree[A])(f: A => B): Tree[B] = fold(tree)(null: Tree[B])((s, t) => {
    t match {
      case Left(Leaf(a)) => Leaf(f(a))
      case Right(Branch(l, r)) => Branch(map(l)(f), map(r)(f))
    }
  })

  println(map(Leaf(1))(_ * 2))
  println(map(Branch(Branch(Leaf(1), Leaf(5)), Branch(Leaf(4), Leaf(3))))(_ * 2))
  println(map(Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(8), Branch(Leaf(9), Leaf(7)))))(_ * 2))

}