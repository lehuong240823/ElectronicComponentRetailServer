package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Order
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, Int> {
    override fun findAll(pageable: Pageable): Page<Order>
    fun findOrdersByOrderStatus_Id(pageable: Pageable, orderStatusId: Byte): Page<Order>
    fun findOrdersByUser_Id(pageable: Pageable, userId: Int): Page<Order>
    fun findOrdersByVoucher_Id(pageable: Pageable, voucherId: Int): Page<Order>
}