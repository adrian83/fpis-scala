package chapter03

object Exercise_03_04 extends App {

  def drop[A](list: List[A], n: Int): List[A] = {
    n match {
      case 0 => list
      case _ => drop(Exercise_03_02.tail(list), n - 1)
    }
  }

  println(drop(List(1, 2, 3, 4, 5), 2))

}