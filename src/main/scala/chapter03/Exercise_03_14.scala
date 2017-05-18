package chapter03

object Exercise_03_14 extends App {

  def append[A](elem: A, as: List[A]): List[A] = as.foldLeft(List(elem))((a, b) => a :+ b)

  println(append(1, List(2, 3)))

}