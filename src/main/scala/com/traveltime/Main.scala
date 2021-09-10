package com.traveltime

object Main extends zio.App {

  def run(args: List[String]) =
    result.map(println).exitCode

  val result = SendGridClient
    .make("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")
    .use(_.sendEmail("hello Man"))
}