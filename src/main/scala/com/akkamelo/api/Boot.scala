package com.akkamelo.api

import akka.actor.ActorSystem
import com.akkamelo.api.http.{ClientService, Server}

object Boot extends App {
  println("Starting Akkamelo")
  implicit val system: ActorSystem = ActorSystem("akkamelo")

  val host = Config.server("host").asInstanceOf[String]
  val port = Config.server("port").asInstanceOf[Int]
  val server = startServer(host, port, ClientService())

  def startServer(host: String, port: Int, service: ClientService): Server = Server.newStartedAt(host, port, service)
}

object Config {
  val server = Map("host" -> "localhost", "port" -> 8080)
}