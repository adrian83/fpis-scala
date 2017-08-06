package chapter06

class SimpleRNG05(seed: Long) extends SimpleRNG04(seed) {
  
override def double(rng: RNG): (Double, RNG) = {
  
  def fu(n: RNG): (Int, RNG) = {
    val t = n.nextInt
    if(t._1 != Int.MaxValue) t else {
      val nRNG:RNG = new SimpleRNG(t._1)
      fu(nRNG)
    }
  }
  
  map(fu)(i => i.toDouble)(rng)
}

}

object Ex5 extends App {
  
  val rnb1 = new SimpleRNG05(15L)
  val rnb2 = new SimpleRNG05(17L)
  
  val t1 = rnb1.double(rnb2)
  println(t1)
  val t2 = rnb1.double(rnb2)
  println(t2)
  val t3 = rnb1.double(t2._2)
  println(t3)

}