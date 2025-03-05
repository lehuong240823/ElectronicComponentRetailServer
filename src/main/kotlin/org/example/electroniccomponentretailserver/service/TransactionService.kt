package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.Transaction
import org.example.electroniccomponentretailserver.repository.TransactionRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.stereotype.Service

@Service
class TransactionService(private val transactionRepository: TransactionRepository) {

    fun getAllTransactions(): List<Transaction> = transactionRepository.findAll()

    fun getTransactionById(id: Int): Transaction? = transactionRepository.findById(id).orElse(null)

    fun saveTransaction(role: Transaction): Transaction = transactionRepository.save(role)

    fun updateTransaction(id: Int, updatedTransaction: Transaction): Transaction? {
        return if (transactionRepository.existsById(id)) {
            val existingTransaction: Transaction = transactionRepository.findById(id).get()
            updateEntity(existingTransaction, updatedTransaction)
            transactionRepository.save(existingTransaction)
        } else {
            null
        }
    }

    fun deleteTransaction(id: Int) = transactionRepository.deleteById(id)
}