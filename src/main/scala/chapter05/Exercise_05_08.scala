package chapter05

object Exercise_05_08 extends App {

  def constant[A](a: A): Stream[A] = Stream.cons(a, constant(a))

  println(Exercise_05_01.toList(Exercise_05_02.take(3, constant(5))))

}