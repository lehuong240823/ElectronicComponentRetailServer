package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.Product
import org.example.electroniccomponentretailserver.repository.ProductRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun getAllProducts(): List<Product> = productRepository.findAll()

    fun getProductById(id: Int): Product? = productRepository.findById(id).orElse(null)

    fun saveProduct(role: Product): Product = productRepository.save(role)

    fun updateProduct(id: Int, updatedProduct: Product): Product? {
        return if (productRepository.existsById(id)) {
            val existingProduct: Product = productRepository.findById(id).get()
            updateEntity(existingProduct, updatedProduct)
            productRepository.save(existingProduct)
        } else {
            null
        }
    }

    fun deleteProduct(id: Int) = productRepository.deleteById(id)
}