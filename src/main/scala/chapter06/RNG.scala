package chapter06

trait RNG { 
  type Rand[+A] = RNG => (A, RNG)

  def nextInt: (Int, RNG) 
  
  def map[A,B](s: RNG => (A, RNG))(f: A => B): RNG => (B, RNG) = 
    rng => { 
      val (a, rng2) = s(rng)
      (f(a), rng2) 
      }  
}

class SimpleRNG(seed: Long) extends RNG {
  override def nextInt: (Int, RNG) = {
    val nextSeed = (seed * 0x492A634D762L + 0x12AD234L) & 0xFFFFFFFFFFFFL
    val nextRNG = new SimpleRNG(nextSeed)
    val i = (nextSeed >>> 16).toInt
    (i, nextRNG)
  }
}

