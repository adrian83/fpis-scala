package chapter03

object Exercise_03_16 extends App {

  def incAll(as: List[Int]): List[Int] = as match {
    case x :: xs => (x + 1) :: incAll(xs)
    case _ => Nil
  }

  println(incAll(List(1, 2, 3)))

}