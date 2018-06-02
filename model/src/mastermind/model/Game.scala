package mastermind.model

case class Game(
  solution: Quadruplet,
  attempts: List[Quadruplet]
) {

  lazy val lastAttemptScore: Option[Score] = attempts.headOption.map(Score.from(solution, _))

  lazy val scores: List[Score] = attempts.map(Score.from(solution, _))

  def +(attempt: Quadruplet): Game = copy(attempts = attempt :: this.attempts)

  lazy val isSolved: Boolean = lastAttemptScore.exists(_.isPerfect)


}
