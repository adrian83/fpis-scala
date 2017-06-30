package chapter05

object Exercise_05_15 extends App {

  def tails[A](s: Stream[A]): Stream[Stream[A]] =
    Exercise_05_11.unfold((s, true))(st => if (!st._2) None else st._1 match {
      case Empty      => Some((Empty, (Empty, false)))
      case Cons(h, t) => Some((st._1, (t(), true)))
    })

  println(Exercise_05_01.toList(tails(Stream(1, 2, 3))))

}