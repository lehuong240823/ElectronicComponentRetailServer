package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.OrderStatus
import org.example.electroniccomponentretailserver.repository.OrderStatusRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.stereotype.Service

@Service
class OrderStatusService(private val orderStatusRepository: OrderStatusRepository) {

    fun getAllOrderStatuss(): List<OrderStatus> = orderStatusRepository.findAll()

    fun getOrderStatusById(id: Byte): OrderStatus? = orderStatusRepository.findById(id).orElse(null)

    fun saveOrderStatus(role: OrderStatus): OrderStatus = orderStatusRepository.save(role)

    fun updateOrderStatus(id: Byte, updatedOrderStatus: OrderStatus): OrderStatus? {
        return if (orderStatusRepository.existsById(id)) {
            val existingOrderStatus: OrderStatus = orderStatusRepository.findById(id).get()
            updateEntity(existingOrderStatus, updatedOrderStatus)
            orderStatusRepository.save(existingOrderStatus)
        } else {
            null
        }
    }

    fun deleteOrderStatus(id: Byte) = orderStatusRepository.deleteById(id)
}