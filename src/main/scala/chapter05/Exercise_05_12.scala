package chapter05

object Exercise_05_12 extends App {

  def fibs(): Stream[Int] = Exercise_05_11.unfold((0, 1))(t => Some(t._1, (t._2, t._1 + t._2)))

  def from(n: Int): Stream[Int] = Exercise_05_11.unfold(n)(t => Some((t, t + 1)))

  def constant[A](a: A): Stream[A] = Exercise_05_11.unfold(a)(t => Some((t, t)))

  def ones(): Stream[Int] = Exercise_05_11.unfold(1)(_ => Some((1, 1)))

  println(Exercise_05_01.toList(Exercise_05_02.take(6, fibs())))
  println(Exercise_05_01.toList(Exercise_05_02.take(6, from(6))))
  println(Exercise_05_01.toList(Exercise_05_02.take(6, constant(6))))
  println(Exercise_05_01.toList(Exercise_05_02.take(6, ones())))

}