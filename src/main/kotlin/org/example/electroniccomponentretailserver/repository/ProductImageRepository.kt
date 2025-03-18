package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.ProductImage
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ProductImageRepository: JpaRepository<ProductImage, Int> {
    override fun findAll(pageable: Pageable): Page<ProductImage>
    fun findProductImagesByProduct_Id(pageable: Pageable, productId: Int): Page<ProductImage>
}