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