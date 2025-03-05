package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.ProductImage
import org.springframework.data.jpa.repository.JpaRepository

interface ProductImageRepository : JpaRepository<ProductImage, Int> {
}