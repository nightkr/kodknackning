name := "kodknackning"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache
)     

play.Project.playScalaSettings

lazy val kodknackning = project.in(file(".")).aggregate(replsampler).dependsOn(replsampler)

lazy val replsampler = RootProject(uri("git://github.com/teozkr/scala-repl-sampler.git#b51a09e66dde14e53220bbd47d31d86d40cb533d"))
