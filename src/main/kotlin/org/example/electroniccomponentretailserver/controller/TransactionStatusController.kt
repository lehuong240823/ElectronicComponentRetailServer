package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.TransactionStatus
import org.example.electroniccomponentretailserver.service.TransactionStatusService
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/transaction-statuss")
class TransactionStatusController(private val transactionStatusService: TransactionStatusService) {

    @GetMapping
    fun getAllTransactionStatuss(): List<TransactionStatus> = transactionStatusService.getAllTransactionStatuss()

    @GetMapping("/{id}")
    fun getTransactionStatusById(@PathVariable id: Byte): ResponseEntity<TransactionStatus> {
        val transactionStatus = transactionStatusService.getTransactionStatusById(id)
        return if (transactionStatus != null) ResponseEntity.ok(transactionStatus) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createTransactionStatus(@RequestBody transactionStatus: TransactionStatus): TransactionStatus = transactionStatusService.saveTransactionStatus(transactionStatus)

    @PutMapping("/{id}")
    fun updateTransactionStatus(@PathVariable id: Byte, @RequestBody updatedTransactionStatus: TransactionStatus): ResponseEntity<TransactionStatus> {
        val transactionStatus = transactionStatusService.updateTransactionStatus(id, updatedTransactionStatus)
        return if (transactionStatus != null) ResponseEntity.ok(transactionStatus) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteTransactionStatus(@PathVariable id: Byte): ResponseEntity<Void> {
        transactionStatusService.deleteTransactionStatus(id)
        return ResponseEntity.noContent().build()
    }
}