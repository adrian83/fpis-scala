package chapter03

object Exercise_03_24 extends App {

  def hasSubsequence[A](as: List[A], c: List[A]): Boolean = {
    def contains[A](fst: List[A], snd: List[A]): Boolean = {
      snd match {
        case Nil => true
        case y :: ys => fst match {
          case Nil => false
          case x :: xs => if (y == x) contains(xs, ys) else false
        }
      }
    }

    c match {
      case Nil => true
      case y :: ys => {
        as match {
          case Nil => false
          case x :: xs => {
            if (x == y) contains(xs, ys) else hasSubsequence(xs, c)
          }
        }
      }
    }
  }

  println(hasSubsequence(List(1, 2, 3, 4, 5, 6, 7), Nil))
  println(hasSubsequence(List(1, 2, 3, 4, 5, 6, 7), List(1)))
  println(hasSubsequence(List(1, 2, 3, 4, 5, 6, 7), List(1, 2, 3, 4)))
  println(hasSubsequence(List(1, 2, 3, 4, 5, 6, 7), List(5, 6, 7)))
  println(hasSubsequence(List(1, 2, 3, 4, 5, 6, 7), List(7)))

  println(hasSubsequence(List(1, 2, 3, 4, 5, 6, 7), List(0)))
  println(hasSubsequence(List(1, 2, 3, 4, 5, 6, 7), List(2, 3, 4, 6)))
  println(hasSubsequence(List(1, 2, 3, 3, 4, 5, 6, 7), List(3, 4, 6)))
  println(hasSubsequence(List(1, 2, 3, 4, 5, 6, 7), List(8)))

}