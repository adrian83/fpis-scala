package chapter02

object Exercise_02_03 extends App {

  def curry[A, B, C](f: (A, B) => C): A => (B => C) = (a: A) => (b: B) => f(a, b)

  println(curry((a: Int, b: Int) => a + b)(3)(5))

}