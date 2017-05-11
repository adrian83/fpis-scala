package chapter03

object Exercise_03_03 extends App {

  def setHead[A](elem: A, list: List[A]): List[A] = {
    list match {
      case x :: xs => elem :: xs
      case Nil => throw new IllegalStateException("List cannot be empty")
    }
  }

  println(setHead("a", List("b", "b", "c")))

}