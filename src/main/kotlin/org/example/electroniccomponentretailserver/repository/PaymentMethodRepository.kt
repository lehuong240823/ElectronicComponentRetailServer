package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.PaymentMethod
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentMethodRepository : JpaRepository<PaymentMethod, Byte> {
}