package chapter03

object Exercise_03_22 extends App {

  def zip(l1: List[Int], l2: List[Int]): List[Int] = l1 match {
    case x :: xs => x + l2.head :: zip(xs, l2.tail)
    case Nil => Nil
  }

  println(zip(List(1, 2, 3), List(4, 5, 6)))

}