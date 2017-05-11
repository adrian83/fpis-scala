package chapter03

object Exercise_03_02 extends App {

  def tail[A](list: List[A]): List[A] = {
    list match {
      case x :: xs => xs
      case Nil => throw new IllegalStateException("List cannot be empty")
    }
  }

  println(tail(List(1, 2, 3)))

}