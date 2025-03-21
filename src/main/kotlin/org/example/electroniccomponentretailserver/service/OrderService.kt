package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.Order
import org.example.electroniccomponentretailserver.repository.OrderRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class OrderService(private val orderRepository: OrderRepository) {

    fun getAllOrders(pageable: Pageable): Page<Order> = orderRepository.findAll(pageable)

    fun getOrderById(id: Int): Order? = orderRepository.findById(id).orElse(null)

    fun saveOrder(role: Order): Order = orderRepository.save(role)

    fun updateOrder(id: Int, updatedOrder: Order): Order? {
        return if (orderRepository.existsById(id)) {
            val existingOrder: Order = orderRepository.findById(id).get()
            updateEntity(existingOrder, updatedOrder)
            orderRepository.save(existingOrder)
        } else {
            null
        }
    }

    fun deleteOrder(id: Int) = orderRepository.deleteById(id)

    fun getOrdersByOrderStatusId(pageable: Pageable, orderStatusId: Byte): Page<Order> = orderRepository.findOrdersByOrderStatus_Id(pageable, orderStatusId)

    fun getOrdersByUserId(pageable: Pageable, userId: Int): Page<Order> = orderRepository.findOrdersByUser_Id(pageable, userId)

    fun getOrdersByVoucherId(pageable: Pageable, voucherId: Int): Page<Order> = orderRepository.findOrdersByVoucher_Id(pageable, voucherId)
}