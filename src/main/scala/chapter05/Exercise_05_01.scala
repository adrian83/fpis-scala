package chapter05

object Exercise_05_01 extends App {

  def toList[A](s: Stream[A]): List[A] = s match {
    case Empty => Nil
    case Cons(h, t) => h() :: toList(t())
  }

  println(toList(Empty))
  println(toList(Stream(1, 2, 3)))

}