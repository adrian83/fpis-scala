package chapter05

object Exercise_05_02 extends App {

  def take[A](n: Int, s: Stream[A]): Stream[A] = n match {
    case 0 => Stream.empty
    case _ => s match {
      case Empty => Stream.empty
      case Cons(h, t) =>Stream.cons(h(), take(n - 1, t()))
    }
  }

  def drop[A](n: Int, s: Stream[A]): Stream[A] = n match {
    case 0 => s
    case _ => s match {
      case Empty => s
      case Cons(h, t) => drop(n - 1, t())
    }
  }

  println(Exercise_05_01.toList(take(2, Stream(1, 2, 3, 4))))
  println(Exercise_05_01.toList(drop(2, Stream(1, 2, 3, 4))))

}