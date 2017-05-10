package chapter02

object Exercise_02_04 extends App {

  def uncurry[A, B, C](f: A => B => C): (A, B) => C = (a: A, b: B) => f(a)(b)

  println(uncurry((a: Int) => (b: Int) => a + b)(1, 2))
  
}