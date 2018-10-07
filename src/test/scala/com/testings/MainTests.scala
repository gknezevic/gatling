package com.testings

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class MainTests extends Simulation {
  val httpConf = http
    .baseUrl("http://localhost:8080/rest")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  val scn = scenario("Main Tests")
    .exec(http("Main page request")
      .get("/strings")
      .check(status.find.in(200)))
    .pause(5)

  val postScn = scenario("Post new stuff")
    .exec(http("Post request")
      .post("/strings")
      .check(status.find.in(200)))
    .pause(5)

  val extScn = scenario("ListConf").exec(ListAndAddConfiguration.simpleFlow)

  setUp(
    scn.inject(atOnceUsers(2)),
    postScn.inject(atOnceUsers(3)),
    extScn.inject(rampUsers(5) during(10))
  ).protocols(httpConf)
}