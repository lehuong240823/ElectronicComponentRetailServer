package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.Order
import org.example.electroniccomponentretailserver.repository.OrderRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService(private val orderRepository: OrderRepository) {

    fun getAllOrders(pageable: Pageable): Page<Order> = orderRepository.findAll(pageable)

    fun getOrderById(id: Int): Order? = orderRepository.findById(id).orElse(null)

    //fun saveOrder(order: Order): Order = orderRepository.save(order)

    @Transactional
    fun createOrder(order: Order, cartItemIds: List<Int>): Order {
        val id = orderRepository.createOrder(
            order.user?.id!!,
            order.address!!,
            cartItemIds.joinToString(",")
        )
        return orderRepository.findById(id).get()
    }

    @Transactional
    fun updateOrder(id: Int, updatedOrder: Order): Order? {
        return if (orderRepository.existsById(id)) {
            val existingOrder: Order = orderRepository.findById(id).get()
            updateEntity(existingOrder, updatedOrder)
            orderRepository.save(existingOrder)
        } else {
            null
        }
    }

    @Transactional
    fun deleteOrder(id: Int) = orderRepository.deleteById(id)

    fun getOrdersByOrderStatusId(pageable: Pageable, orderStatusId: Byte): Page<Order> = orderRepository.findOrdersByOrderStatus_Id(pageable, orderStatusId)

    fun findOrdersByOrderStatusIdAndUserId(pageable: Pageable, userId: Int, orderStatusId: Byte): Page<Order> = orderRepository.findOrdersByUser_IdAndOrderStatus_Id(pageable, userId, orderStatusId)

    fun getOrdersByUserId(pageable: Pageable, userId: Int): Page<Order> = orderRepository.findOrdersByUser_Id(pageable, userId)

    fun getOrdersByVoucherId(pageable: Pageable, voucherId: Int): Page<Order> = orderRepository.findOrdersByVoucher_Id(pageable, voucherId)

}