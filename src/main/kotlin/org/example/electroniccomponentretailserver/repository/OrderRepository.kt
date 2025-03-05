package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Int> {
}