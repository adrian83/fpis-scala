package chapter05

object Exercise_05_05 extends App {

  def takeWhile2[A](p: A => Boolean)(s: Stream[A]): Stream[A] =
    s.foldRight(Empty: Stream[A])((a, f) => if (p(a)) Stream.cons(a, f) else Empty)

  println(Exercise_05_01.toList(takeWhile2((i: Int) => i < 3)(Stream(1, 2, 3, 4))))
  println(Exercise_05_01.toList(takeWhile2((i: Int) => i < 3)(Stream(6, 2, 3, 4))))

}