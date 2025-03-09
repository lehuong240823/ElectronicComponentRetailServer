package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.TransactionStatus
import org.example.electroniccomponentretailserver.repository.TransactionStatusRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TransactionStatusService(private val transactionStatusRepository: TransactionStatusRepository) {

    fun getAllTransactionStatuss(pageable: Pageable): Page<TransactionStatus> = transactionStatusRepository.findAll(pageable)

    fun getTransactionStatusById(id: Byte): TransactionStatus? = transactionStatusRepository.findById(id).orElse(null)

    fun saveTransactionStatus(role: TransactionStatus): TransactionStatus = transactionStatusRepository.save(role)

    fun updateTransactionStatus(id: Byte, updatedTransactionStatus: TransactionStatus): TransactionStatus? {
        return if (transactionStatusRepository.existsById(id)) {
            val existingTransactionStatus: TransactionStatus = transactionStatusRepository.findById(id).get()
            updateEntity(existingTransactionStatus, updatedTransactionStatus)
            transactionStatusRepository.save(existingTransactionStatus)
        } else {
            null
        }
    }

    fun deleteTransactionStatus(id: Byte) = transactionStatusRepository.deleteById(id)
}