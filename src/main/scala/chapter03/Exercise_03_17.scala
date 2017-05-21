package chapter03

object Exercise_03_17 extends App {

  def longsToStrings(longs: List[Long]): List[String] = longs match {
    case x :: xs => x.toString :: longsToStrings(xs)
    case _ => Nil
  }

  println(longsToStrings(List(1, 2, 3)))

}