package chapter05

object Exercise_05_07 extends App {

  def map[A, B](mf: A => B)(s: Stream[A]): Stream[B] =
    s.foldRight(Empty: Stream[B])((a, f) => Stream.cons(mf(a), f))

  def filter[A](mf: A => Boolean)(s: Stream[A]): Stream[A] =
    s.foldRight(Empty: Stream[A])((a, f) => if (mf(a)) Stream.cons(a, f) else f)

  def append[A](a: A)(s: Stream[A]): Stream[A] =
    s.foldRight(Stream(a))((e, f) => Stream.cons(e, f))

  def flatMap[A](s: Stream[Stream[A]]): Stream[A] =
    s.foldRight(Empty: Stream[A])((a, f) => a.foldRight(f)((e, el) => Stream.cons(e, el)))

  println(Exercise_05_01.toList(map((a: Int) => a * 2)(Stream(1, 2, 3))))
  println(Exercise_05_01.toList(filter((a: Int) => a == 2)(Stream(1, 2, 3, 2, 5))))
  println(Exercise_05_01.toList(append(2)(Stream(3, 4, 5))))
  println(Exercise_05_01.toList(flatMap(Stream(Stream(3, 4, 5), Stream(6, 7, 8)))))

}