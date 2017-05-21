package chapter03

object Exercise_03_21 extends App {

  def filter[A](as: List[A])(f: A => Boolean): List[A] = as.flatMap(a => if (f(a)) List(a) else Nil)

  println(filter(List(1, 2, 3, 4))(a => a % 2 == 0))

}