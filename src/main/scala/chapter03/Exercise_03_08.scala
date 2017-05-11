package chapter03

object Exercise_03_08 extends App {

  def testFoldRight(list: List[Int]) = {
    list.foldRight(Nil: List[Int])((a, b) => a :: b)
  }

  println(testFoldRight(List(1, 2, 3)))

}