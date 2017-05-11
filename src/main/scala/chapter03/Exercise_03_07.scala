package chapter03

object Exercise_03_07 extends App {

  def product(list: List[Double]): Double = {
    list.foldRight(1.0)((a: Double, b: Double) => {
      println(s"$a * $b = ${a * b}")
      a * b
    })
  }

  println(product(List(1.0, 2.0, 3.0, 0.0, 4.0, 5.0)))

}