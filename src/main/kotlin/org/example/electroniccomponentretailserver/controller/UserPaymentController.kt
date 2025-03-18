package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.UserPayment
import org.example.electroniccomponentretailserver.service.UserPaymentService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user-payments")
class UserPaymentController(private val userPaymentService: UserPaymentService) {

    @GetMapping
    fun getAllUserPayments(@PageableDefault(size = 10) pageable: Pageable): Page<UserPayment> = userPaymentService.getAllUserPayments(pageable)

    @GetMapping("/{id}")
    fun getUserPaymentById(@PathVariable id: Int): ResponseEntity<UserPayment> {
        val userPayment = userPaymentService.getUserPaymentById(id)
        return if (userPayment != null) ResponseEntity.ok(userPayment) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createUserPayment(@RequestBody userPayment: UserPayment): UserPayment = userPaymentService.saveUserPayment(userPayment)

    @PutMapping("/{id}")
    fun updateUserPayment(@PathVariable id: Int, @RequestBody updatedUserPayment: UserPayment): ResponseEntity<UserPayment> {
        val userPayment = userPaymentService.updateUserPayment(id, updatedUserPayment)
        return if (userPayment != null) ResponseEntity.ok(userPayment) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteUserPayment(@PathVariable id: Int): ResponseEntity<Void> {
        userPaymentService.deleteUserPayment(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/payment-method/id/{paymentMethodId}")
    fun getUserPaymentsByPaymentMethodId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable("paymentMethodId") paymentMethodId: Byte): Page<UserPayment> {
        return userPaymentService.getUserPaymentsByPaymentMethodId(pageable, paymentMethodId)
    }

    @GetMapping("/user/id/{userId}")
    fun getUserPaymentsByUserId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable("userId") userId: Int): Page<UserPayment> {
        return userPaymentService.getUserPaymentsByUserId(pageable, userId)
    }
}