package chapter03

object Exercise_03_10 extends App {
  
  println(1.to(Int.MaxValue).foldRight(0)(_ + _))
  
}