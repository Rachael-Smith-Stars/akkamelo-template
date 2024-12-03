package com.akkamelo.api.actor.client.domain.state

case class Credit(value: Int, description: String, timestamp: Long = System.currentTimeMillis()) extends Transaction {
  require(value >= 0, "Debit value cannot be negative")
  require(description.nonEmpty && description.length <= 10, "Description must have a value")
}