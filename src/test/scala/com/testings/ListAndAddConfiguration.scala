package com.testings

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object ListAndAddConfiguration {

  val simpleFlow = exec(http("Configuration") // let's give proper names, as they are displayed in the reports
    .get("/strings"))
    .pause(7)
    .exec(http("Search animals")
      .get("/strings/animals"))
    .pause(2)
    .exec(http("Configuration again")
      .get("/strings"))
    .pause(3)
}
