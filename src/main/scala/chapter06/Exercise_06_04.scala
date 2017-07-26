package chapter06

class SimpleRNG04(seed: Long) extends SimpleRNG03(seed) {

  def ints(count: Int)(rng: RNG): (List[Int], RNG) = {
    count match {
      case 0 => (Nil, rng)
      case a => {
        val c = rng.nextInt
        val t = ints(count - 1)(c._2)
        (t._1 :+ c._1, t._2)
      }
    }
  }
}

object Ex4 extends App {

  val rnb1 = new SimpleRNG04(15L)

  val t1 = rnb1.ints(6)(rnb1)
  println(t1)
  val t2 = rnb1.ints(6)(rnb1)
  println(t2)
  val t3 = rnb1.ints(6)(t2._2)
  println(t3)

}