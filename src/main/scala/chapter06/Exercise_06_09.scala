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