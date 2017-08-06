package chapter06

class SimpleRNG08(seed: Long) extends SimpleRNG07(seed) {

  def flatMap[A, B](f: Rand[A])(g: A => Rand[B]): Rand[B] = {
    rng =>
      {
        val t = f(rng)
        g(t._1)(t._2)
      }
  }
}

object Ex8 extends App with RNG {

  val rnb = new SimpleRNG08(15L)

  val r: Rand[Int] = rng => (5, rng)

  val t = rnb.flatMap(r)(i => rng => (i + "--", rng))(rnb)
  println(t)

  def nextInt: (Int, RNG) = (4, null)

}