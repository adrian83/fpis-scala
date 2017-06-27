package chapter05

object Exercise_05_06 extends App {

  def headOption[A](s: Stream[A]): Option[A] =
    s.foldRight(None: Option[A])((a, f) => Some(a))

  println(headOption(Stream.empty))
  println(headOption(Stream(1, 2, 3)))

}