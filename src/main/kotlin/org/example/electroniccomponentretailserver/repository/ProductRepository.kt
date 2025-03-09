package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Int> {
    override fun findAll(pageable: Pageable): Page<Product>
}