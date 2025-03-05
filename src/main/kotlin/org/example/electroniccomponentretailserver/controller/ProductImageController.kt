package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.ProductImage
import org.example.electroniccomponentretailserver.service.ProductImageService
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/product-images")
class ProductImageController(private val productImageService: ProductImageService) {

    @GetMapping
    fun getAllProductImages(): List<ProductImage> = productImageService.getAllProductImages()

    @GetMapping("/{id}")
    fun getProductImageById(@PathVariable id: Int): ResponseEntity<ProductImage> {
        val productImage = productImageService.getProductImageById(id)
        return if (productImage != null) ResponseEntity.ok(productImage) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createProductImage(@RequestBody productImage: ProductImage): ProductImage = productImageService.saveProductImage(productImage)

    @PutMapping("/{id}")
    fun updateProductImage(@PathVariable id: Int, @RequestBody updatedProductImage: ProductImage): ResponseEntity<ProductImage> {
        val productImage = productImageService.updateProductImage(id, updatedProductImage)
        return if (productImage != null) ResponseEntity.ok(productImage) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteProductImage(@PathVariable id: Int): ResponseEntity<Void> {
        productImageService.deleteProductImage(id)
        return ResponseEntity.noContent().build()
    }
}