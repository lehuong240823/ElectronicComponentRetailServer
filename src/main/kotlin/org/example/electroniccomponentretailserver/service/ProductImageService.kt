package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.ProductImage
import org.example.electroniccomponentretailserver.repository.ProductImageRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProductImageService(private val productImageRepository: ProductImageRepository) {

    fun getAllProductImages(pageable: Pageable): Page<ProductImage> = productImageRepository.findAll(pageable)

    fun getProductImageById(id: Int): ProductImage? = productImageRepository.findById(id).orElse(null)

    fun saveProductImage(role: ProductImage): ProductImage = productImageRepository.save(role)

    fun updateProductImage(id: Int, updatedProductImage: ProductImage): ProductImage? {
        return if (productImageRepository.existsById(id)) {
            val existingProductImage: ProductImage = productImageRepository.findById(id).get()
            updateEntity(existingProductImage, updatedProductImage)
            productImageRepository.save(existingProductImage)
        } else {
            null
        }
    }

    fun deleteProductImage(id: Int) = productImageRepository.deleteById(id)

    fun getProductImagesByProductId(pageable: Pageable, productId: Int): Page<ProductImage> = productImageRepository.findProductImagesByProduct_Id(pageable, productId)
}