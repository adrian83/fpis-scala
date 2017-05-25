package chapter03

object Exercise_03_23 extends App {

  def zipWith[A, B](l1: List[A], l2: List[A])(f: (A, A) => B): List[B] = l1 match {
    case x :: xs => f(x, l2.head) :: zipWith(xs, l2.tail)(f)
    case Nil => Nil
  }

  println(zipWith(List(1, 2, 3), List(4, 5, 6))((a1, a2) => a1.toString + a2.toString))

}