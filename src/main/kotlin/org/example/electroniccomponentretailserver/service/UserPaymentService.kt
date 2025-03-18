package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.UserPayment
import org.example.electroniccomponentretailserver.repository.UserPaymentRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class UserPaymentService(private val userPaymentRepository: UserPaymentRepository) {

    fun getAllUserPayments(pageable: Pageable): Page<UserPayment> = userPaymentRepository.findAll(pageable)

    fun getUserPaymentById(id: Int): UserPayment? = userPaymentRepository.findById(id).orElse(null)

    fun saveUserPayment(role: UserPayment): UserPayment = userPaymentRepository.save(role)

    fun updateUserPayment(id: Int, updatedUserPayment: UserPayment): UserPayment? {
        return if (userPaymentRepository.existsById(id)) {
            val existingUserPayment: UserPayment = userPaymentRepository.findById(id).get()
            updateEntity(existingUserPayment, updatedUserPayment)
            userPaymentRepository.save(existingUserPayment)
        } else {
            null
        }
    }

    fun deleteUserPayment(id: Int) = userPaymentRepository.deleteById(id)

    fun getUserPaymentsByPaymentMethodId(pageable: Pageable, paymentMethodId: Byte): Page<UserPayment> = userPaymentRepository.findUserPaymentsByPaymentMethod_Id(pageable, paymentMethodId)

    fun getUserPaymentsByUserId(pageable: Pageable, userId: Int): Page<UserPayment> = userPaymentRepository.findUserPaymentsByUser_Id(pageable, userId)
}