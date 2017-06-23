package chapter05

object Exercise_05_03 extends App {

  def takeWhile[A](p: A => Boolean)(s: Stream[A]): Stream[A] = s match {
    case Empty => Stream.empty
    case Cons(h, t) => if (p(h())) Stream.cons(h(), takeWhile(p)(t())) else Stream.empty
  }

  println(Exercise_05_01.toList(takeWhile((i: Int) => i < 3)(Stream(1, 2, 3, 4))))

}