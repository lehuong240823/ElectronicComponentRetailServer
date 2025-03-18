package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.Transaction
import org.example.electroniccomponentretailserver.service.TransactionService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/transactions")
class TransactionController(private val transactionService: TransactionService) {

    @GetMapping
    fun getAllTransactions(@PageableDefault(size = 10) pageable: Pageable): Page<Transaction> = transactionService.getAllTransactions(pageable)

    @GetMapping("/{id}")
    fun getTransactionById(@PathVariable id: Int): ResponseEntity<Transaction> {
        val transaction = transactionService.getTransactionById(id)
        return if (transaction != null) ResponseEntity.ok(transaction) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createTransaction(@RequestBody transaction: Transaction): Transaction = transactionService.saveTransaction(transaction)

    @PutMapping("/{id}")
    fun updateTransaction(@PathVariable id: Int, @RequestBody updatedTransaction: Transaction): ResponseEntity<Transaction> {
        val transaction = transactionService.updateTransaction(id, updatedTransaction)
        return if (transaction != null) ResponseEntity.ok(transaction) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteTransaction(@PathVariable id: Int): ResponseEntity<Void> {
        transactionService.deleteTransaction(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/payment-method/id/{paymentMethodId}")
    fun getTransactionsByPaymentMethodId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable("paymentMethodId") paymentMethodId: Byte): Page<Transaction> {
        return transactionService.getTransactionsByPaymentMethodId(pageable, paymentMethodId)
    }

    @GetMapping("/transaction-status/id/{transactionStatusId}")
    fun getTransactionsByTransactionStatusId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable("transactionStatusId") transactionStatusId: Byte): Page<Transaction> {
        return transactionService.getTransactionsByTransactionStatusId(pageable, transactionStatusId)
    }

    @GetMapping("/order/id/{orderId}")
    fun getTransactionsByOrderId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable("orderId") orderId: Int): Page<Transaction> {
        return transactionService.getTransactionsByOrderId(pageable, orderId)
    }
}