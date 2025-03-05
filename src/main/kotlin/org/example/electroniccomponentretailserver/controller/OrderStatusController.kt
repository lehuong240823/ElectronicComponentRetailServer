package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.OrderStatus
import org.example.electroniccomponentretailserver.service.OrderStatusService
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/order-statuss")
class OrderStatusController(private val orderStatusService: OrderStatusService) {

    @GetMapping
    fun getAllOrderStatuss(): List<OrderStatus> = orderStatusService.getAllOrderStatuss()

    @GetMapping("/{id}")
    fun getOrderStatusById(@PathVariable id: Byte): ResponseEntity<OrderStatus> {
        val orderStatus = orderStatusService.getOrderStatusById(id)
        return if (orderStatus != null) ResponseEntity.ok(orderStatus) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createOrderStatus(@RequestBody orderStatus: OrderStatus): OrderStatus = orderStatusService.saveOrderStatus(orderStatus)

    @PutMapping("/{id}")
    fun updateOrderStatus(@PathVariable id: Byte, @RequestBody updatedOrderStatus: OrderStatus): ResponseEntity<OrderStatus> {
        val orderStatus = orderStatusService.updateOrderStatus(id, updatedOrderStatus)
        return if (orderStatus != null) ResponseEntity.ok(orderStatus) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteOrderStatus(@PathVariable id: Byte): ResponseEntity<Void> {
        orderStatusService.deleteOrderStatus(id)
        return ResponseEntity.noContent().build()
    }
}