package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.OrderItem
import org.example.electroniccomponentretailserver.service.OrderItemService
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/order-items")
class OrderItemController(private val orderItemService: OrderItemService) {

    @GetMapping
    fun getAllOrderItems(): List<OrderItem> = orderItemService.getAllOrderItems()

    @GetMapping("/{id}")
    fun getOrderItemById(@PathVariable id: Int): ResponseEntity<OrderItem> {
        val orderItem = orderItemService.getOrderItemById(id)
        return if (orderItem != null) ResponseEntity.ok(orderItem) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createOrderItem(@RequestBody orderItem: OrderItem): OrderItem = orderItemService.saveOrderItem(orderItem)

    @PutMapping("/{id}")
    fun updateOrderItem(@PathVariable id: Int, @RequestBody updatedOrderItem: OrderItem): ResponseEntity<OrderItem> {
        val orderItem = orderItemService.updateOrderItem(id, updatedOrderItem)
        return if (orderItem != null) ResponseEntity.ok(orderItem) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteOrderItem(@PathVariable id: Int): ResponseEntity<Void> {
        orderItemService.deleteOrderItem(id)
        return ResponseEntity.noContent().build()
    }
}