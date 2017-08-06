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

object Ex6 extends App with RNG {

  val rnb1 = new SimpleRNG06(15L)

  val r1: Rand[Int] = rng => (5, rng)
  val r2: Rand[Long] = rng => (9l, rng)

  val t1 = rnb1.map2(r1, r2)((a, b) => a + "-" + b)(rnb1)
  println(t1)

  def nextInt: (Int, RNG) = (4, null)

}





