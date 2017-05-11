package chapter03

object Exercise_03_06 extends App {

  def init[A](list: List[A]): List[A] = {
    list match {
      case Nil => Nil
      case x :: Nil => Nil
      case x :: xs => x :: init(xs)
    }
  }

  println(init(List(1, 2, 3, 4)))

}