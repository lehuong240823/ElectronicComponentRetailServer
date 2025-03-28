package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.Cart
import org.example.electroniccomponentretailserver.service.CartService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/carts")
class CartController(private val cartService: CartService) {

    @GetMapping
    fun getAllCarts(@PageableDefault(size = 10) pageable: Pageable): Page<Cart> = cartService.getAllCarts(pageable)

    @GetMapping("/{id}")
    fun getCartById(@PathVariable id: Int): ResponseEntity<Cart> {
        val cart = cartService.getCartById(id)
        return if (cart != null) ResponseEntity.ok(cart) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createCart(@RequestBody cart: Cart): Cart {
        val uid = cart.user?.id ?: return throw IllegalArgumentException("User ID is required")
        val pid = cart.product?.id ?: return throw IllegalArgumentException("Product ID is required")

        return getCartByUserIdAndProductId(uid, pid)?.let { existCart ->
            updateCart(existCart.id!!, existCart.apply {
                var newQuantity = existCart.quantity?.plus(cart.quantity ?: 0)
                if (newQuantity != null) {
                    if(newQuantity>product?.stock!!){
                        newQuantity = product?.stock
                    }
                }
                quantity = newQuantity
            }).body
        } ?: cartService.saveCart(cart)
    }

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

    @GetMapping("/user/id/{userId}")
    fun getCartsByUserId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable("userId") userId: Int): Page<Cart> {
        return cartService.getCartsByUserId(pageable, userId)
    }

    @GetMapping("/product/id/{productId}")
    fun getCartsByProductId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable("productId") productId: Int): Page<Cart> {
        return cartService.getCartsByProductId(pageable, productId)
    }

    @GetMapping("/find")
    fun getCartByUserIdAndProductId(
        @RequestParam userId: Int,
        @RequestParam productId: Int
    ): Cart? {
        return cartService.getCartsByUserIdAndProductId(userId, productId)
    }
}