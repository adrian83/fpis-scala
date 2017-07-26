package chapter06

class SimpleRNG01(seed: Long) extends SimpleRNG(seed) {

  def nonNegativeInt(rng: RNG): (Int, RNG) = {

    val t = rng.nextInt
    val t2 = if (t._1 != Int.MinValue) t else {
      val nRNG = new SimpleRNG(t._1)
      nonNegativeInt(nRNG)
    }
    return t2
  }
}

object Ex1 extends App {

  val rnb1 = new SimpleRNG01(15L)
  val t1 = rnb1.nonNegativeInt(rnb1)
  println(t1)
  val t2 = rnb1.nonNegativeInt(rnb1)
  println(t2)
  val t3 = rnb1.nonNegativeInt(t2._2)
  println(t3)

}