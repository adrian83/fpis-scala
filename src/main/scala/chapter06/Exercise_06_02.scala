package chapter06

class SimpleRNG02(seed: Long) extends SimpleRNG01(seed) {

  def double(rng: RNG): (Double, RNG) = {

    val t = rng.nextInt
    val t2 = if (t._1 != Int.MaxValue) (t._1.toDouble, t._2) else double(new SimpleRNG(t._1))
    (t2._1.toDouble / Int.MaxValue.toDouble, t2._2)
  }
}

object Ex2 extends App {

  val rnb1 = new SimpleRNG02(15L)
  val t1 = rnb1.double(rnb1)
  println(t1)
  val t2 = rnb1.double(rnb1)
  println(t2)
  val t3 = rnb1.double(t2._2)
  println(t3)

}