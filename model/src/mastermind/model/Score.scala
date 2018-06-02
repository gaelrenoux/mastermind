package mastermind.model

case class Score(
                  goodPosition: Int,
                  badPosition: Int
                ) {

  lazy val isPerfect: Boolean = goodPosition == 4

}

object Score {
  def from(solution: Quadruplet, attempt: Quadruplet): Score =
    from(solution.toVector zip attempt.toVector)

  private def from(solutionAndAttempt: Vector[(Peg, Peg)]): Score = {
    val (goodPosition, badPosition) = solutionAndAttempt partition { case (s, a) => s == a }

    val (unmatchedSol, unmatchedAtt) = badPosition.unzip
    val unmatchedSolCountByColor = unmatchedSol.groupBy(identity).mapValues(_.size)
    val unmatchedAttCountByColor = unmatchedAtt.groupBy(identity).mapValues(_.size)
    val colors = unmatchedSolCountByColor.keySet ++ unmatchedAttCountByColor.keySet

    val unmatchedCounts = for (k <- colors.toSeq) yield {
      val sVal = unmatchedSolCountByColor.getOrElse(k, 0)
      val uVal = unmatchedAttCountByColor.getOrElse(k, 0)
      sVal min uVal
    }

    Score(goodPosition.size, unmatchedCounts.sum)
  }
}