package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Cart
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface CartRepository: JpaRepository<Cart, Int> {
    override fun findAll(pageable: Pageable): Page<Cart>
}