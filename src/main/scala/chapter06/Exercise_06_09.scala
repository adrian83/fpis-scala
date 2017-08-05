package chapter06

class SimpleRNG09(seed: Long) extends SimpleRNG08(seed) {

  override def double(rng: RNG): (Double, RNG) = {

    def f1(r1: RNG): (Int, RNG) = {
      val t = r1.nextInt
      if (t._1 == Int.MaxValue) f1(new SimpleRNG(t._1)) else t
    }

    def f2(i: Int): Rand[Double] = rng => (i.toDouble / Int.MaxValue.toDouble, rng)

    flatMap(f1)(f2)(rng)

  }
  
  

}

object Ex9 extends App {
  
    val rnb1 = new SimpleRNG09(15L)
  val t1 = rnb1.double(rnb1)
  println(t1)
  val t2 = rnb1.double(rnb1)
  println(t2)
  val t3 = rnb1.double(t2._2)
  println(t3)
  
}

