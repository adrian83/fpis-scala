package chapter04

sealed trait Either[+E, +A] {
  def map[B](f: A => B): Either[E, B]
  def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B]
  def orElse[EE >: E, B >: A](b: => Either[EE, B]): Either[EE, B]
  def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C]
}

case class Right[+A](value: A) extends Either[Nothing, A] {
  def map[B](f: A => B): Either[Nothing, B] = Right(f(value))
  def flatMap[EE >: Nothing, B](f: A => Either[EE, B]): Either[EE, B] = f(value)
  def orElse[EE >: Nothing, B >: A](b: => Either[EE, B]): Either[EE, B] = Right(value)
  def map2[EE >: Nothing, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C] = b.flatMap(b => Right(f(value, b)))
}

object Exercise_04_06 extends App {

  println(Right(3)
    .map2(Right(2))((a, b) => a * b)
    .orElse(Right(-1))
    .map(_ * 2)
    .flatMap(a => Right(a * 2)))

}