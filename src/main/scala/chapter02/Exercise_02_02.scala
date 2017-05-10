package chapter02

object Exercise_02_02 extends App {

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    if (as.length < 2) true else {
      if (ordered(as(0), as(1))) isSorted(as.drop(1), ordered) else false
    }
  }

  println(isSorted(Array(1, 2, 3, 4, 5), (a: Int, b: Int) => a < b))
  println(isSorted(Array(1, 2, 4, 3, 5), (a: Int, b: Int) => a < b))

  println(isSorted(Array("v", "g", "as", "qwe"), (a: String, b: String) => a.length() <= b.length()))
  println(isSorted(Array("v", "g", "qwe", "as"), (a: String, b: String) => a.length() <= b.length()))
}