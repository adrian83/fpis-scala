package chapter03

object Exercise_03_12 extends App {

  def reverse[A](as: List[A]): List[A] = as.foldLeft(Nil: List[A])((a: List[A], b: A) => b :: a)

  println(reverse(List(1, 2, 3)))

}