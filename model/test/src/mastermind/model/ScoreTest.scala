package mastermind.model

import org.scalatest.{FlatSpec, Matchers}
import Peg.Keys._

class ScoreTest extends FlatSpec with Matchers {

  behavior of "Score.from"

  it should "count good values with good position" in {
    val solution = Quadruplet(R, G, B, Y)
    Score.from(solution, Quadruplet(R, G, B, Y)).goodPosition should be(4)
    Score.from(solution, Quadruplet(G, G, Y, Y)).goodPosition should be(2)
    Score.from(solution, Quadruplet(P, G, Y, B)).goodPosition should be(1)
    Score.from(solution, Quadruplet(P, B, G, B)).goodPosition should be(0)
  }

  it should "count good values with bad position" in {
    val solution = Quadruplet(R, G, B, Y)
    Score.from(solution, Quadruplet(R, G, B, Y)).badPosition should be(0)
    Score.from(solution, Quadruplet(G, R, Y, B)).badPosition should be(4)
    Score.from(solution, Quadruplet(G, P, G, G)).badPosition should be(1)
    Score.from(solution, Quadruplet(G, G, G, G)).badPosition should be(0)
    Score.from(solution, Quadruplet(O, P, P, O)).badPosition should be(0)
    Score.from(Quadruplet(P, P, P, G), Quadruplet(R, R, P, P)).badPosition should be(1)
  }
}
