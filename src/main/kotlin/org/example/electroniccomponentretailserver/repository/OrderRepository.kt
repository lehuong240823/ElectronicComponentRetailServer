package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Order
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.query.Procedure
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

interface OrderRepository: JpaRepository<Order, Int> {
    override fun findAll(pageable: Pageable): Page<Order>
    fun findOrdersByOrderStatus_Id(pageable: Pageable, orderStatusId: Byte): Page<Order>
    fun findOrdersByUser_Id(pageable: Pageable, userId: Int): Page<Order>
    fun findOrdersByVoucher_Id(pageable: Pageable, voucherId: Int): Page<Order>

    @Procedure(procedureName = "create_order_with_order_items")
    fun createOrder(
        @Param("userId") userId: Int,
        @Param("orderAddress") address: String,
        @Param("cartItemIds") cartItemIds: String): Int
}