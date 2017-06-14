package chapter04

object Exercise_04_03 extends App {

  def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = a.flatMap(aa => b.map(bb => f(aa, bb)))

  println(map2(Some(1), Some("a"))((i, s) => s"$i-$s"))
  println(map2(Some(1), None)((i, s) => s"$i-$s"))
  println(map2(None, Some("a"))((i, s) => s"$i-$s"))

}