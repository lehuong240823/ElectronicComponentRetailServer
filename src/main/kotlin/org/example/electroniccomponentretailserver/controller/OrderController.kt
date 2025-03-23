package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.Order
import org.example.electroniccomponentretailserver.service.OrderService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders")
class OrderController(private val orderService: OrderService) {

    @GetMapping
    fun getAllOrders(@PageableDefault(size = 10) pageable: Pageable): Page<Order> = orderService.getAllOrders(pageable)

    @GetMapping("/{id}")
    fun getOrderById(@PathVariable id: Int): ResponseEntity<Order> {
        val order = orderService.getOrderById(id)
        return if (order != null) ResponseEntity.ok(order) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createOrder(@RequestBody order: Order, @RequestParam cartItemIds: List<Int>): ResponseEntity<Order> {
        println("aaa"+order.user?.fullName)
        val createdOrder = orderService.createOrder(order, cartItemIds)
        return ResponseEntity.ok(createdOrder)
    }

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

    @GetMapping("/order-status/id/{orderStatusId}")
    fun getOrdersByOrderStatusId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable("orderStatusId") orderStatusId: Byte): Page<Order> {
        return orderService.getOrdersByOrderStatusId(pageable, orderStatusId)
    }

    @GetMapping("/user/id/{userId}")
    fun getOrdersByUserId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable("userId") userId: Int): Page<Order> {
        return orderService.getOrdersByUserId(pageable, userId)
    }

    @GetMapping("/voucher/id/{voucherId}")
    fun getOrdersByVoucherId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable("voucherId") voucherId: Int): Page<Order> {
        return orderService.getOrdersByVoucherId(pageable, voucherId)
    }
}