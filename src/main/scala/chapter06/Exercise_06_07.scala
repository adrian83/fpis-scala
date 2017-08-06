package chapter06

class SimpleRNG07(seed: Long) extends SimpleRNG06(seed) {

  def sequence[A](fs: List[Rand[A]]): Rand[List[A]] = {
    rng =>
      {
        def f[A](l: List[Rand[A]], r: RNG): (List[A], RNG) = {
          l match {
            case Nil => (Nil, r)
            case x :: xs => {
              val t = x(r)
              val t2 = f(xs, t._2)
              (t._1 :: t2._1, t2._2)
            }
          }
        }
        f(fs, rng)
      }
  }
}

object Ex7 extends App with RNG {

  val rnb = new SimpleRNG07(15L)

  val r1: Rand[Int] = rng => (5, rng)
  val r2: Rand[Int] = rng => (6, rng)
  val r3: Rand[Int] = rng => (7, rng)

  val t = rnb.sequence(List(r1,r2,r3))(rnb)
  println(t)

  def nextInt: (Int, RNG) = (4, null)

}

