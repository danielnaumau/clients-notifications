name := "clients-notifications"

version := "0.1"

scalaVersion := "2.13.6"
resolvers ++=
  Seq(
    Resolver.bintrayRepo("igeolise", "maven")
  )

val http4sVersion = "0.23.3"
val zioVersion    = "1.0.1"

libraryDependencies ++= Seq(
  "org.http4s"   %% "http4s-blaze-server" % http4sVersion,
  "org.http4s"   %% "http4s-dsl"          % http4sVersion,
  "dev.zio"      %% "zio"                 % zioVersion,
  "com.igeolise" %% "3scale-sdk"          % "1.1.1",
)