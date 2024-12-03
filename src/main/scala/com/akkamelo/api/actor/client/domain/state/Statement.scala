package com.akkamelo.api.actor.client.domain.state

case class Statement(balance: Int, lastTransactions: List[Transaction])
