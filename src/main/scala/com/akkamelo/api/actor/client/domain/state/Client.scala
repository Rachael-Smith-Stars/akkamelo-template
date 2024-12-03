package com.akkamelo.api.actor.client.domain.state

import scala.language.postfixOps
import scala.util.{Failure, Success, Try}

case class Client(id: Long, balance: Int, transactions: List[Transaction] = List(), creditLimit: Int = 0) {

  def add(transaction: Transaction): Client  = {
    val result = tryAdd(transaction)
    result match {
      case Failure(e) => throw e
      case Success(value) => value
    }
  }

  private def tryAdd(transaction: Transaction): Try[Client] = {
    transaction match {
      case debit: Debit =>
        if (balance - debit.value < -creditLimit) {
          Failure(InvalidTransactionException("Balance lower than credit limit"))
        } else {
          Success(copy(id = id, balance = balance - debit.value, transactions = transaction :: transactions, creditLimit = creditLimit))
        }
      case credit: Credit =>
        Success(copy(id = id, balance = balance + credit.value, transactions = transaction :: transactions, creditLimit = creditLimit))
      case _ =>
        Failure(InvalidTransactionException("Unknown transaction type"))
    }
  }

  def getStatement(balance: Int, transactions: List[Transaction]): Statement = {
    def helper(transactions: List[Transaction], acc: List[Transaction]): List[Transaction] = {
      transactions match {
        case Nil => acc
        case head :: tail =>
          if (acc.size < 10) helper(tail, head :: acc)
          else acc
      }
    }
    Statement(balance, helper(transactions, List()).reverse)
  }

}

object Client {
  def initial(): Client = new Client(1, 0, List(), 0)
}