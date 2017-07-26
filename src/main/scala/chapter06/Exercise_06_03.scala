package chapter06

class SimpleRNG03(seed: Long) extends SimpleRNG02(seed) {

  def intDouble(rng: RNG): ((Int, Double), RNG) = {
    val t1 = double(rng)
    val t2 = t1._2.nextInt
    ((t2._1, t1._1), t2._2)
  }

  def doubleInt(rng: RNG): ((Double, Int), RNG) = {
    val t = intDouble(rng)
    ((t._1._2, t._1._1), t._2)
  }

  def double3(rng: RNG): ((Double, Double, Double), RNG) = {
    val t1 = double(rng)
    val t2 = double(t1._2)
    val t3 = double(t2._2)
    ((t1._1, t2._1, t3._1), t3._2)
  }

}

object Ex3 extends App {

  val rnb1 = new SimpleRNG03(15L)

  val t1 = rnb1.intDouble(rnb1)
  println(t1)
  val t2 = rnb1.intDouble(rnb1)
  println(t2)
  val t3 = rnb1.intDouble(t2._2)
  println(t3)

  val t4 = rnb1.doubleInt(rnb1)
  println(t4)
  val t5 = rnb1.doubleInt(rnb1)
  println(t5)
  val t6 = rnb1.doubleInt(t5._2)
  println(t6)

  val t7 = rnb1.doubleInt(rnb1)
  println(t7)
  val t8 = rnb1.doubleInt(rnb1)
  println(t8)
  val t9 = rnb1.doubleInt(t8._2)
  println(t9)

}