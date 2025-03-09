package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.PaymentMethod
import org.example.electroniccomponentretailserver.service.PaymentMethodService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/payment-methods")
class PaymentMethodController(private val paymentMethodService: PaymentMethodService) {

    @GetMapping
    fun getAllPaymentMethods(@PageableDefault(size = 10) pageable: Pageable): Page<PaymentMethod> = paymentMethodService.getAllPaymentMethods(pageable)

    @GetMapping("/{id}")
    fun getPaymentMethodById(@PathVariable id: Byte): ResponseEntity<PaymentMethod> {
        val paymentMethod = paymentMethodService.getPaymentMethodById(id)
        return if (paymentMethod != null) ResponseEntity.ok(paymentMethod) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createPaymentMethod(@RequestBody paymentMethod: PaymentMethod): PaymentMethod = paymentMethodService.savePaymentMethod(paymentMethod)

    @PutMapping("/{id}")
    fun updatePaymentMethod(@PathVariable id: Byte, @RequestBody updatedPaymentMethod: PaymentMethod): ResponseEntity<PaymentMethod> {
        val paymentMethod = paymentMethodService.updatePaymentMethod(id, updatedPaymentMethod)
        return if (paymentMethod != null) ResponseEntity.ok(paymentMethod) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deletePaymentMethod(@PathVariable id: Byte): ResponseEntity<Void> {
        paymentMethodService.deletePaymentMethod(id)
        return ResponseEntity.noContent().build()
    }
}