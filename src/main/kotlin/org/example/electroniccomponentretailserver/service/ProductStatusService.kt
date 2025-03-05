package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.ProductStatus
import org.example.electroniccomponentretailserver.repository.ProductStatusRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.stereotype.Service

@Service
class ProductStatusService(private val productStatusRepository: ProductStatusRepository) {

    fun getAllProductStatuss(): List<ProductStatus> = productStatusRepository.findAll()

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