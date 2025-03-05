package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.Order
import org.example.electroniccomponentretailserver.service.OrderService
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders")
class OrderController(private val orderService: OrderService) {

    @GetMapping
    fun getAllOrders(): List<Order> = orderService.getAllOrders()

    @GetMapping("/{id}")
    fun getOrderById(@PathVariable id: Int): ResponseEntity<Order> {
        val order = orderService.getOrderById(id)
        return if (order != null) ResponseEntity.ok(order) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createOrder(@RequestBody order: Order): Order = orderService.saveOrder(order)

    @PutMapping("/{id}")
    fun updateOrder(@PathVariable id: Int, @RequestBody updatedOrder: Order): ResponseEntity<Order> {
        val order = orderService.updateOrder(id, updatedOrder)
        return if (order != null) ResponseEntity.ok(order) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteOrder(@PathVariable id: Int): ResponseEntity<Void> {
        orderService.deleteOrder(id)
        return ResponseEntity.noContent().build()
    }
}