package com.traveltime

import com.traveltime.Models._
import sttp.client.UriContext
import sttp.client3.{SttpBackend, basicRequest}
import sttp.client3._
import sttp.client3.circe._
import sttp.client3.asynchttpclient.zio.AsyncHttpClientZioBackend

sealed trait SendGridClient[F[_]] {
  def sendEmail(firstName: String): F[Response[Either[String, String]]]
}

object SendGridClient {

  def make[F[_]](apiKey: String) = {
    AsyncHttpClientZioBackend
      .managed()
      .map( backend => new SendGridClientImpl(apiKey, backend))
  }

  class SendGridClientImpl[F[_], S](apiKey: String, backend: SttpBackend[F, S]) extends SendGridClient[F] {
    override def sendEmail(firstName: String): F[Response[Either[String, String]]] = {
      val body = SendGridBody(
        from = From("mr.redribon@gmail.com"),
        personalizations = List(
          Personalization(
            to = List(Receiver("sadfreddy@gmail.com")),
            dynamicTemplateData = TestTemplate(firstName)
          )
        ),
        templateId = "d-ac4b26726bc34d478efe44e5f3dcfd21"
      )

      val request = basicRequest
        .post(uri"https://api.sendgrid.com/v3/mail/send")
        .body(body)
        .auth
        .bearer(apiKey)

      println(request)

      backend.send(request)
    }
  }
}