package chapter03

object Exercise_03_20 extends App {

  def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] = as match {
    case x :: xs => f(x) ::: flatMap(xs)(f)
    case Nil => Nil
  }

  println(flatMap(List(1, 2, 3))(a => List(a.toString, a.toString)))

}