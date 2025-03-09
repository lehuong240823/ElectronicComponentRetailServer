package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.OrderItem
import org.example.electroniccomponentretailserver.repository.OrderItemRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class OrderItemService(private val orderItemRepository: OrderItemRepository) {

    fun getAllOrderItems(pageable: Pageable): Page<OrderItem> = orderItemRepository.findAll(pageable)

    fun getOrderItemById(id: Int): OrderItem? = orderItemRepository.findById(id).orElse(null)

    fun saveOrderItem(role: OrderItem): OrderItem = orderItemRepository.save(role)

    fun updateOrderItem(id: Int, updatedOrderItem: OrderItem): OrderItem? {
        return if (orderItemRepository.existsById(id)) {
            val existingOrderItem: OrderItem = orderItemRepository.findById(id).get()
            updateEntity(existingOrderItem, updatedOrderItem)
            orderItemRepository.save(existingOrderItem)
        } else {
            null
        }
    }

    fun deleteOrderItem(id: Int) = orderItemRepository.deleteById(id)
}