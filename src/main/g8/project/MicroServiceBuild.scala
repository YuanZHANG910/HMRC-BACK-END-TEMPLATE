import sbt._
import play.sbt.PlayImport._
import play.core.PlayVersion
import $mainPackage$SbtAutoBuildPlugin
import $mainPackage$sbtdistributables.SbtDistributablesPlugin
import $mainPackage$versioning.SbtGitVersioning

object MicroServiceBuild extends Build with MicroService {

  val appName = "$name$"

  override lazy val appDependencies: Seq[ModuleID] = compile ++ test()

  val compile = Seq(
    ws,
    "uk.gov.hmrc" %% "microservice-bootstrap" % "5.8.0",
    "uk.gov.hmrc" %% "play-authorisation" % "4.2.0",
    "uk.gov.hmrc" %% "play-health" % "2.0.0",
    "uk.gov.hmrc" %% "play-url-binders" % "2.0.0",
    "uk.gov.hmrc" %% "play-config" % "3.0.0",
    "uk.gov.hmrc" %% "logback-json-logger" % "3.1.0",
    "uk.gov.hmrc" %% "domain" % "4.0.0"
  )

  def test(scope: String = "test,it") = Seq(
    "uk.gov.hmrc" %% "hmrctest" % "2.2.0" % scope,
    "org.scalatest" %% "scalatest" % "2.2.6" % scope,
    "org.pegdown" % "pegdown" % "1.6.0" % scope,
    "com.typesafe.play" %% "play-test" % PlayVersion.current % scope
  )

}
