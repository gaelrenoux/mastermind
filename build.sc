import mill._
import mill.scalalib._
import mill.scalalib.scalafmt._

object model extends ScalaModule with ScalafmtModule {
  def scalaVersion = "2.12.6"

  object test extends Tests { 
    def ivyDeps = Agg(ivy"org.scalatest::scalatest:3.0.5")
    def testFrameworks = Seq("org.scalatest.tools.Framework")
  }
}

//object webui extends ScalaJSModule
