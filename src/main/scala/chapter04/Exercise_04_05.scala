package chapter04

object Exercise_04_05 extends App {

  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = a match {
    case Nil => Some(Nil)
    case x :: xs => {
      f(x) match {
        case None => None
        case Some(v) => traverse(xs)(f).map(l => v :: l)
      }
    }
  }

  println(traverse(List(1, 2, 3))(h => Some(h * 3)))
  println(traverse(List(1, 0, 3))(h => if (h == 0) None else Some(h * 3)))
  println(traverse(Nil)(h => Some(h.toString)))

}