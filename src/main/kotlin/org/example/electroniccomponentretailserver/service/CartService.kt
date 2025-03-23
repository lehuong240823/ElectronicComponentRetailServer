package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.Cart
import org.example.electroniccomponentretailserver.repository.CartRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CartService(private val cartRepository: CartRepository) {

    fun getAllCarts(pageable: Pageable): Page<Cart> = cartRepository.findAll(pageable)

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

    fun getCartsByUserId(pageable: Pageable, userId: Int): Page<Cart> = cartRepository.findCartsByUser_Id(pageable, userId)

    fun getCartsByProductId(pageable: Pageable, productId: Int): Page<Cart> = cartRepository.findCartsByProduct_Id(pageable, productId)

    fun getCartsByUserIdAndProductId(userId: Int, productId: Int): Cart? = cartRepository.findCartsByUser_IdAndProductId(userId, productId).orElse(null)
}