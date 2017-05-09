package chapter02

object Exercise_02_01 extends App {
  
  def fib(n: Int): Int = {
    @annotation.tailrec def f(first: Int, second: Int, index: Int): Int = 
      if(index == 0) first + second else f(second, first + second, index-1)
    
    n match {
      case 1 => 0
      case 2 => 1
      case _ => f(0, 1, n-3)
    }
  }
  
  1 until 40 map fib foreach println
  
}