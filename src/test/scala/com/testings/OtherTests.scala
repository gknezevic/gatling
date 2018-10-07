package com.testings

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class OtherTests extends Simulation{

  val httpConf = http
    .baseUrl("http://localhost:8080/rest")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  val scn = scenario("Numbers Tests")
    .exec(http("numbers")
      .get("/numbers")
      .check(status.find.in(200)))
    .pause(5)

  setUp(
    scn.inject(rampUsers(20) during(5))
  ).protocols(httpConf)

}
