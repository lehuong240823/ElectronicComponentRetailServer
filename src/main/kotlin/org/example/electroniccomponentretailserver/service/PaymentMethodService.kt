package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.PaymentMethod
import org.example.electroniccomponentretailserver.repository.PaymentMethodRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PaymentMethodService(private val paymentMethodRepository: PaymentMethodRepository) {

    fun getAllPaymentMethods(pageable: Pageable): Page<PaymentMethod> = paymentMethodRepository.findAll(pageable)

    fun getPaymentMethodById(id: Byte): PaymentMethod? = paymentMethodRepository.findById(id).orElse(null)

    fun savePaymentMethod(role: PaymentMethod): PaymentMethod = paymentMethodRepository.save(role)

    fun updatePaymentMethod(id: Byte, updatedPaymentMethod: PaymentMethod): PaymentMethod? {
        return if (paymentMethodRepository.existsById(id)) {
            val existingPaymentMethod: PaymentMethod = paymentMethodRepository.findById(id).get()
            updateEntity(existingPaymentMethod, updatedPaymentMethod)
            paymentMethodRepository.save(existingPaymentMethod)
        } else {
            null
        }
    }

    fun deletePaymentMethod(id: Byte) = paymentMethodRepository.deleteById(id)
}