package chapter03

object Exercise_03_11 extends App {

  def sum(as: List[Int]): Int = as.foldLeft(0)(_ + _)

  def product(as: List[Int]): Int = as match {
    case Nil => 0
    case _ => as.foldLeft(1)(_ * _)
  }

  def length[A](as: List[A]): Int = as.foldLeft(0)((a, _) => a + 1)

  println(sum(Nil))
  println(sum(List(1, 2, 3, 4)))

  println(product(Nil))
  println(product(List(1, 2, 3, 4)))

  println(length(Nil))
  println(length(List(1, 2, 3, 4)))

}