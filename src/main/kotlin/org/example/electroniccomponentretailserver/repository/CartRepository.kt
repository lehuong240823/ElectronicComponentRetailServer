package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Cart
import org.springframework.data.jpa.repository.JpaRepository

interface CartRepository : JpaRepository<Cart, Int> {
}