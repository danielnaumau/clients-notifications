package com.traveltime

import io.circe.generic.extras.{Configuration, ConfiguredJsonCodec}

object Models {
  implicit val config: Configuration = Configuration.default.withSnakeCaseMemberNames

  sealed trait DynamicTemplateData

  @ConfiguredJsonCodec
  final case class TestTemplate(firstName: String) extends DynamicTemplateData

  @ConfiguredJsonCodec
  final case class Receiver(email: String) //to be refactored

  @ConfiguredJsonCodec
  final case class Personalization(to: List[Receiver], dynamicTemplateData: TestTemplate)

  @ConfiguredJsonCodec
  final case class From(email: String)

  @ConfiguredJsonCodec
  final case class SendGridBody(
    from: From,
    personalizations: List[Personalization],
    templateId: String
  )
}
