package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Order
import org.example.electroniccomponentretailserver.entity.Transaction
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface TransactionRepository: JpaRepository<Transaction, Int> {
    override fun findAll(pageable: Pageable): Page<Transaction>
    fun findTransactionsByPaymentMethod_Id(pageable: Pageable, paymentMethodId: Byte): Page<Transaction>
    fun findTransactionsByTransactionStatus_Id(pageable: Pageable, transactionStatusId: Byte): Page<Transaction>
    fun findTransactionsByOrder_Id(pageable: Pageable, orderId: Int): Page<Transaction>
    @Query("SELECT t FROM Transaction t WHERE t.order.user.id = :userId AND t.transactionStatus.id = :transactionStatusId")
    fun findTransactionsByUserIdAndStatus(
        pageable: Pageable,
        @Param("userId") userId: Int,
        @Param("transactionStatusId") statusId: Byte,
    ): Page<Transaction>
    @Query("SELECT t FROM Transaction t WHERE t.order.user.id = :userId")
    fun findTransactionsByUserId(pageable: Pageable, userId: Int): Page<Transaction>

}