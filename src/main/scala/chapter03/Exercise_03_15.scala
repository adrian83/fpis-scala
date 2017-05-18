package chapter03

object Exercise_03_15 extends App {

  def flatten[A](as: List[List[A]]): List[A] = as.foldLeft(Nil: List[A])((a, b) => a ::: b)

  println(flatten(List(List(1, 2), List(3, 4))))

}