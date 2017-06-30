package chapter05

object Exercise_05_14 extends App {

  // reimplementation of ex 3 from chapter 4
  def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = a.flatMap(aa => b.map(bb => f(aa, bb)))

  def startsWith[A](s1: Stream[A])(s2: Stream[A]): Boolean =
    Exercise_05_04.forAll((t: (Option[A], Option[A])) => map2(t._1, t._2)((a, b) => a == b)
      .getOrElse(false))(Exercise_05_13.zipAll(s1)(s2))

  println(startsWith(Stream(1, 2, 3))(Stream(1, 2)))
  println(startsWith(Stream(1, 2, 3))(Stream(1, 3)))

}