package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.ProductStatus
import org.springframework.data.jpa.repository.JpaRepository

interface ProductStatusRepository : JpaRepository<ProductStatus, Byte> {
}