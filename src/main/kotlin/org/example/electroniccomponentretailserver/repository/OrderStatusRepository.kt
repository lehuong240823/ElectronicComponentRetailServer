package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.OrderStatus
import org.springframework.data.jpa.repository.JpaRepository

interface OrderStatusRepository : JpaRepository<OrderStatus, Byte> {
}