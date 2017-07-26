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
              (t2._1 :+ t._1, t2._2)
            }
          }
        }
        f(fs, rng)
      }
  }
}