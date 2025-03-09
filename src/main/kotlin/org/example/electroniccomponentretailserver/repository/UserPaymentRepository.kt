package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.UserPayment
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface UserPaymentRepository: JpaRepository<UserPayment, Int> {
    override fun findAll(pageable: Pageable): Page<UserPayment>
}