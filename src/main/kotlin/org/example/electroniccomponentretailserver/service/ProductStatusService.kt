package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.ProductStatus
import org.example.electroniccomponentretailserver.repository.ProductStatusRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProductStatusService(private val productStatusRepository: ProductStatusRepository) {

    fun getAllProductStatuses(pageable: Pageable): Page<ProductStatus> = productStatusRepository.findAll(pageable)

    fun getProductStatusById(id: Byte): ProductStatus? = productStatusRepository.findById(id).orElse(null)

    fun saveProductStatus(role: ProductStatus): ProductStatus = productStatusRepository.save(role)

    fun updateProductStatus(id: Byte, updatedProductStatus: ProductStatus): ProductStatus? {
        return if (productStatusRepository.existsById(id)) {
            val existingProductStatus: ProductStatus = productStatusRepository.findById(id).get()
            updateEntity(existingProductStatus, updatedProductStatus)
            productStatusRepository.save(existingProductStatus)
        } else {
            null
        }
    }

    fun deleteProductStatus(id: Byte) = productStatusRepository.deleteById(id)
}