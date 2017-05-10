package chapter02

object Exercise_02_05 extends App {

  def compose[A, B, C](f: B => C, g: A => B): A => C = (a: A) => f(g(a))

  println(compose((b: String) => b.length, (a: Int) => a.toString)(66))
  println(compose((b: String) => b.length, (a: Int) => a.toString)(5555))

}