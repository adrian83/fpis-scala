package chapter03

object Exercise_03_19 extends App {

  def filter[A](as: List[A])(f: A => Boolean): List[A] = as match {
    case x :: xs => if (f(x)) x :: filter(xs)(f) else filter(xs)(f)
    case _ => Nil
  }

  println(filter(List(1, 2, 3, 4))(a => a % 2 == 0))

}