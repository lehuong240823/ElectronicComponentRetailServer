package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.OrderStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface OrderStatusRepository: JpaRepository<OrderStatus, Byte> {
    override fun findAll(pageable: Pageable): Page<OrderStatus>
}