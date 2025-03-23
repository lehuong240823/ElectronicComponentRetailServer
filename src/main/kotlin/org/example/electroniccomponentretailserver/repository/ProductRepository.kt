package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Int> {
    override fun findAll(pageable: Pageable): Page<Product>
    fun findProductsByProductStatus_Id(pageable: Pageable, productStatusId: Byte): Page<Product>
    fun findProductsByCategory_Id(pageable: Pageable, categoryId: Int): Page<Product>
    fun findProductsByProvider_Id(pageable: Pageable, providerId: Int): Page<Product>
    fun findProductsByNameContainingIgnoreCase(pageable: Pageable, name: String): Page<Product>
}