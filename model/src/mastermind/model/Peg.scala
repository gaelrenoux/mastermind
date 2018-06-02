package mastermind.model

sealed abstract class Peg {
  lazy val code: String = this.getClass.getSimpleName.head.toString
}

object Peg {
  object Green extends Peg
  object Blue extends Peg
  object Red extends Peg
  object Purple extends Peg
  object Orange extends Peg
  object Yellow extends Peg

  object Keys {
    val B: Peg = Blue
    val G: Peg = Green
    val O: Peg = Orange
    val P: Peg = Purple
    val R: Peg = Red
    val Y: Peg = Yellow
  }
}