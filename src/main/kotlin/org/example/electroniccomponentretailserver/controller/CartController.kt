package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.Cart
import org.example.electroniccomponentretailserver.service.CartService
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/carts")
class CartController(private val cartService: CartService) {

    @GetMapping
    fun getAllCarts(): List<Cart> = cartService.getAllCarts()

    @GetMapping("/{id}")
    fun getCartById(@PathVariable id: Int): ResponseEntity<Cart> {
        val cart = cartService.getCartById(id)
        return if (cart != null) ResponseEntity.ok(cart) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createCart(@RequestBody cart: Cart): Cart = cartService.saveCart(cart)

    @PutMapping("/{id}")
    fun updateCart(@PathVariable id: Int, @RequestBody updatedCart: Cart): ResponseEntity<Cart> {
        val cart = cartService.updateCart(id, updatedCart)
        return if (cart != null) ResponseEntity.ok(cart) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteCart(@PathVariable id: Int): ResponseEntity<Void> {
        cartService.deleteCart(id)
        return ResponseEntity.noContent().build()
    }
}