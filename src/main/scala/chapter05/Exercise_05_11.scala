package chapter05

object Exercise_05_11 extends App {

  def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = {
    def next(st: S, fn: S => Option[(A, S)]): Stream[A] = fn(st) match {
      case None => Stream.empty
      case Some((v, newSt)) => Stream.cons(v, next(newSt, fn))
    }
    next(z, f)
  }

  println(Exercise_05_01.toList(unfold(5)(a => if (a < 10) Some(a, a + 1) else None)))

}