package chapter05

object Exercise_05_10 extends App {

  def fibs(): Stream[Int] = {
    def next(a: Int, b: Int): Stream[Int] = Stream.cons(a, next(b, a + b))
    next(0, 1)
  }

  println(Exercise_05_01.toList(Exercise_05_02.take(10, fibs())))

}