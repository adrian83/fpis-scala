package chapter03

object Exercise_03_09 extends App {

  def length[A](as: List[A]): Int = {
    as.foldRight(0)((_, b) => b + 1)
  }

  println(length(Nil))
  println(length(List(1, 2, 3)))

}