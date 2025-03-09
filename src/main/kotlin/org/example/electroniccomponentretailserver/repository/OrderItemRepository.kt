package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.OrderItem
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository: JpaRepository<OrderItem, Int> {
    override fun findAll(pageable: Pageable): Page<OrderItem>
}