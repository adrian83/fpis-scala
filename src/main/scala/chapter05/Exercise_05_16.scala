package chapter05

object Exercise_05_16 extends App {

  def fold[A, B](s: Stream[A])(z: B)(f: (A, B) => B): B = s match {
    case Empty      => z
    case Cons(h, t) => fold(t())(f(h(), z))(f)
  }

  def scanRight[A, B](s: Stream[A])(z: B)(f: (A, B) => B): Stream[B] =
    Exercise_05_11.unfold((s, true))(st => if (!st._2) None else st._1 match {
      case Empty      => Some(z, (Empty, false))
      case Cons(h, t) => Some((fold(st._1)(z)(f), (t(), true)))
    })

  println(fold(Stream(1, 2, 3))(10)(_ + _))

  println(Exercise_05_01.toList(scanRight(Stream(1, 2, 3))(0)(_ + _)))

}