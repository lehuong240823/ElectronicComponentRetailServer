package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.OrderItem
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository : JpaRepository<OrderItem, Int> {
}