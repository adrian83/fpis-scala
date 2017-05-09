package chapter02

object Exercise_02_01 extends App {

  def fib(n: Int): Int = {
    @annotation.tailrec def f(first: Int, second: Int, n: Int): Int =
      n match {
        case 0 => first + second
        case 1 => first
        case 2 => second
        case _ => f(second, first + second, n - 1)
      }
    f(0, 1, n)
  }

  1 until 40 map fib foreach println

}