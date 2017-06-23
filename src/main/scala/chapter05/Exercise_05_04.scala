package chapter05

object Exercise_05_04 extends App {

  def forAll[A](p: A => Boolean)(s: Stream[A]): Boolean = s match {
    case Empty => true
    case Cons(h, t) => if (p(h())) forAll(p)(t()) else false
  }

  println(forAll((i: Int) => i > 0)(Stream(1, 2, 3, 4)))
  println(forAll((i: Int) => i < 4)(Stream(1, 2, 3, 4)))

}

