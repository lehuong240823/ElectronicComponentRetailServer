package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.ProductImage
import org.example.electroniccomponentretailserver.service.ProductImageService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/product-images")
class ProductImageController(private val productImageService: ProductImageService) {

    @GetMapping
    fun getAllProductImages(@PageableDefault(size = 10) pageable: Pageable): Page<ProductImage> = productImageService.getAllProductImages(pageable)

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

    @GetMapping("/product/id/{productId}")
    fun getProductImagesByProductId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable("productId") productId: Int): Page<ProductImage> {
        return productImageService.getProductImagesByProductId(pageable, productId)
    }
}