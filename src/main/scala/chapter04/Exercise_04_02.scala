package chapter04

object Exercise_04_02 extends App {

  def variance(xs: Seq[Double]): Option[Double] = {
    val (sum, count) = xs.foldLeft((0d, 0))((tpl, dbl) => (tpl._1 + dbl, tpl._2 + 1))
    val maybeMean = if (count == 0) None else Some(sum / count)
    maybeMean.map(mean => xs.foldLeft(0d)((s, d) => s + math.pow(d - mean, 2)) / sum)
  }

  println(variance(Nil))
  println(variance(List(1, 2, 3, 4, 6)))

}