package chapter05

object Exercise_05_13 extends App {

  def map[A, B](f: A => B)(s: Stream[A]): Stream[B] =
    Exercise_05_11.unfold(s)(stA => stA match {
      case Empty      => None
      case Cons(h, t) => Some((f(h()), t()))
    })

  def take[A](n: Int)(s: Stream[A]): Stream[A] =
    Exercise_05_11.unfold((n, s))(t => t._1 match {
      case 0 => None
      case _ => t._2 match {
        case Empty       => None
        case Cons(h, ta) => Some((h(), (t._1 - 1, ta())))
      }
    })

  def takeWhile[A](f: A => Boolean)(s: Stream[A]): Stream[A] =
    Exercise_05_11.unfold(s)(st => st match {
      case Empty      => None
      case Cons(h, t) => if (f(h())) Some((h(), t())) else None
    })

  def zipAll[A, B](s1: Stream[A])(s2: Stream[B]): Stream[(Option[A], Option[B])] =
    Exercise_05_11.unfold((s1, s2))(streams => streams._1 match {
      case Empty => None
      case Cons(h1, t1) => streams._2 match {
        case Empty        => None
        case Cons(h2, t2) => Some(((Some(h1()), Some(h2())), (t1(), t2())))
      }
    })

  println(Exercise_05_01.toList(map((a: Int) => a * 2)(Stream(1, 2, 3))))
  println(Exercise_05_01.toList(take(2)(Stream(1, 2, 3))))
  println(Exercise_05_01.toList(takeWhile((a: Int) => a < 3)(Stream(1, 2, 3, 2, 4))))

  println(Exercise_05_01.toList(zipAll(Stream("a", "b", "c"))(Stream(1, 2))))
  println(Exercise_05_01.toList(zipAll(Stream("a", "b", "c"))(Stream(1, 2, 3, 4))))

}