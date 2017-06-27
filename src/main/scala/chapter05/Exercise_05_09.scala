package chapter05

object Exercise_05_09 extends App {

  def from(n: Int): Stream[Int] = Stream.cons(n, from(n + 1))

  println(Exercise_05_01.toList(Exercise_05_02.take(3, from(5))))

}