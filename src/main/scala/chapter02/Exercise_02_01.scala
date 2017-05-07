package chapter02

object Exercise_02_01 extends App {
  
  // baaaaad impl
  def fib(n: Int): Int = {
    n match {
      case 1 => 0
      case 2 => 1
      case _ => fib(n-1) + fib(n-2)
    }
  }
  
  
  
  println(fib(1))
  println(fib(2))
  println(fib(3))
  println(fib(4))
  println(fib(5))
  println(fib(6))
  println(fib(7))
  println(fib(8))
  println(fib(9))
  
}