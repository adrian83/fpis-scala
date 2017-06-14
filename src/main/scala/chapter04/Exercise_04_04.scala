package chapter04

object Exercise_04_04 extends App {

  def sequence[A](xs: List[Option[A]]): Option[List[A]] = xs match {
    case Nil => Some(List.empty[A])
    case y :: ys => y match {
      case None => None
      case Some(v) => sequence(ys).map(l => v :: l)
    }
  }

  println(sequence(List(Some(1), Some(5), Some(9))))
  println(sequence(List(Some(1), None, Some(9))))

}