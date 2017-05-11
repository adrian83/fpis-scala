package chapter03

object Exercise_03_05 extends App {

  def dropWhile[A](list: List[A], f: A => Boolean): List[A] = {
    list match {
      case Nil => Nil
      case x :: xs => if (f(x)) list else dropWhile(xs, f)
    }
  }

  println(dropWhile(List(1, 2, 3, 4, 5), (a: Int) => a == 3))

}