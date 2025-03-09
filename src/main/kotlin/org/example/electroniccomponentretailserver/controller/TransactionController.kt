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
}