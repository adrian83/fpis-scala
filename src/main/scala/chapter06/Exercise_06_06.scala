package chapter06

class SimpleRNG06(seed: Long) extends SimpleRNG05(seed) {

  def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] = {
    rng =>
      {
        val tA = ra(rng)
        val tB = rb(tA._2)
        (f(tA._1, tB._1), tB._2)
      }
  }
}

object Ex6 extends App {

  val rnb1 = new SimpleRNG06(15L)

  val t1 = rnb1.ints(6)(rnb1)
  println(t1)
  val t2 = rnb1.ints(6)(rnb1)
  println(t2)
  val t3 = rnb1.ints(6)(t2._2)
  println(t3)

}





