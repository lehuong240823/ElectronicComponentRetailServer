package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.UserPayment
import org.example.electroniccomponentretailserver.service.UserPaymentService
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user-payments")
class UserPaymentController(private val userPaymentService: UserPaymentService) {

    @GetMapping
    fun getAllUserPayments(): List<UserPayment> = userPaymentService.getAllUserPayments()

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
}