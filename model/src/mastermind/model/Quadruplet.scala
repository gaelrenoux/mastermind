package mastermind.model

case class Quadruplet(wrapped: (Peg, Peg, Peg, Peg)) extends AnyVal {

  def toVector = Vector(wrapped._1, wrapped._2, wrapped._3, wrapped._4)

}

object Quadruplet