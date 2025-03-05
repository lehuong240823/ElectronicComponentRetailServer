package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Int> {
}