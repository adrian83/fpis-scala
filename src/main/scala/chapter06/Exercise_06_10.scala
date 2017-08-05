package chapter06

case class State[S, +A](run: S => (A, S))

object State {

  def unit[S, A](a: A): State[S, A] = State(s => (a, s))

  def map[S, A, B](st: State[S, A])(f: A => B): State[S, B] =
    State(s => {
      val t = st.run(s)
      (f(t._1), t._2)
    })

  def map2[S, A, B, C](st1: State[S, A])(st2: State[S, B])(f: (A, B) => C): State[S, C] =
    State(s => {
      val t1 = st1.run(s)
      val t2 = st2.run(t1._2)
      val c = f(t1._1, t2._1)
      (c, t2._2)
    })

  def flatMap[S, A, B](st1: State[S, A])(g: A => State[S, B]): State[S, B] =
    State(s => {
      val t = st1.run(s)
      g(t._1).run(t._2)
    })

  def sequence[S, A](fs: List[State[S, A]]): State[S, List[A]] = {

    def l[S, A](f: List[State[S, A]], s: S): (List[A], S) = {
      f match {
        case Nil => (Nil, s)
        case x :: xs => {
          val t = x.run(s)
          val t2 = l(xs, t._2)
          (t._1 :: t2._1, t2._2)
        }
      }
    }
    State(s => l(fs, s))
  }
}

object Exercise_06_10 extends App {

  println(State.unit(5).run("test"))

  val s: State[String, Int] = State.unit[String, Int](5)
  println((State.map(s)(i => "thisistest:" + i)).run("test"))

  val longSt = State.unit[String, Long](5l)
  val intSt = State.unit[String, Int](8)
  println(State.map2(longSt)(intSt)((a, b) => a + "-" + b).run("test"))

  val st1: State[String, Int] = State.unit[String, Int](1)
  println(State.flatMap(st1)(i => State.unit[String, Int](i)).run("test"))

  val s1: State[String, Int] = State.unit[String, Int](1)
  val s2: State[String, Int] = State.unit[String, Int](2)
  val s3: State[String, Int] = State.unit[String, Int](3)
  println(State.sequence(List(s1, s2, s3)).run("test"))
}

