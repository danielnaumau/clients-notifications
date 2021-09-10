name := "clients-notifications"

version := "0.1"

scalaVersion := "2.13.6"

resolvers ++=
  Seq(
    Resolver.bintrayRepo("igeolise", "maven")
  )


val http4sVersion = "0.23.3"
val zioVersion    = "1.0.1"
val circeVersion    = "0.14.1"

libraryDependencies ++= Seq(
  "com.softwaremill.sttp.client3" %% "core" % "3.3.14",
  "com.softwaremill.sttp.client3" %% "async-http-client-backend-zio" % "3.3.14",
  "com.softwaremill.sttp.client3" %% "circe" % "3.3.14",
  "io.circe" %% "circe-generic-extras" % circeVersion,
  "dev.zio"      %% "zio"                 % zioVersion,
  "io.circe"     %% "circe-core"          % circeVersion,
  "io.circe"     %% "circe-generic"       % circeVersion,
  "com.igeolise" %% "3scale-sdk"          % "1.1.1",
)

scalacOptions += "-Ymacro-annotations"
