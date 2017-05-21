package chapter03

object Exercise_03_18 extends App {

  def map[A, B](as: List[A])(f: A => B): List[B] = as match {
    case x :: xs => f(x) :: map(xs)(f)
    case _ => Nil
  }

  println(map(List(1, 2, 3))(a => List(a, a)))

}