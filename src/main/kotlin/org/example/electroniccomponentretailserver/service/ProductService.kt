package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.Product
import org.example.electroniccomponentretailserver.repository.ProductRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun getAllProducts(pageable: Pageable): Page<Product> = productRepository.findAll(pageable)

    fun getProductById(id: Int): Product? = productRepository.findById(id).orElse(null)

    fun saveProduct(role: Product): Product = productRepository.save(role)

    @Transactional
    fun updateProduct(id: Int, updatedProduct: Product): Product? {
        return if (productRepository.existsById(id)) {
            val existingProduct: Product = productRepository.findById(id).get()
            updateEntity(existingProduct, updatedProduct)
            productRepository.save(existingProduct)
        } else {
            null
        }
    }

    @Transactional
    fun deleteProduct(id: Int) = productRepository.deleteById(id)

    fun getProductsByProductStatusId(pageable: Pageable, productStatusId: Byte): Page<Product> = productRepository.findProductsByProductStatus_Id(pageable, productStatusId)

    fun getProductsByCategoryId(pageable: Pageable, categoryId: Int): Page<Product> = productRepository.findProductsByCategory_Id(pageable, categoryId)

    fun getProductsByProviderId(pageable: Pageable, providerId: Int): Page<Product> = productRepository.findProductsByProvider_Id(pageable, providerId)

    fun findProductsByNameContainingIgnoreCase(pageable: Pageable, name: String): Page<Product> {
        return productRepository.findProductsByNameContainingIgnoreCase(pageable, name)
    }
}