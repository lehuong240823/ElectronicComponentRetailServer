package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.Transaction
import org.example.electroniccomponentretailserver.repository.TransactionRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TransactionService(private val transactionRepository: TransactionRepository) {

    fun getAllTransactions(pageable: Pageable): Page<Transaction> = transactionRepository.findAll(pageable)

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

    fun getTransactionsByPaymentMethodId(pageable: Pageable, paymentMethodId: Byte): Page<Transaction> = transactionRepository.findTransactionsByPaymentMethod_Id(pageable, paymentMethodId)

    fun getTransactionsByTransactionStatusId(pageable: Pageable, transactionStatusId: Byte): Page<Transaction> = transactionRepository.findTransactionsByTransactionStatus_Id(pageable, transactionStatusId)

    fun getTransactionsByOrderId(pageable: Pageable, orderId: Int): Page<Transaction> = transactionRepository.findTransactionsByOrder_Id(pageable, orderId)
}