package com.akkamelo.api.actor.client.domain.state

trait Transaction {
  def value(): Int
  def timestamp(): Long
}

