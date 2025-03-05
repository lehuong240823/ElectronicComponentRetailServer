package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.Cart
import org.example.electroniccomponentretailserver.repository.CartRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.stereotype.Service

@Service
class CartService(private val cartRepository: CartRepository) {

    fun getAllCarts(): List<Cart> = cartRepository.findAll()

    fun getCartById(id: Int): Cart? = cartRepository.findById(id).orElse(null)

    fun saveCart(role: Cart): Cart = cartRepository.save(role)

    fun updateCart(id: Int, updatedCart: Cart): Cart? {
        return if (cartRepository.existsById(id)) {
            val existingCart: Cart = cartRepository.findById(id).get()
            updateEntity(existingCart, updatedCart)
            cartRepository.save(existingCart)
        } else {
            null
        }
    }

    fun deleteCart(id: Int) = cartRepository.deleteById(id)
}