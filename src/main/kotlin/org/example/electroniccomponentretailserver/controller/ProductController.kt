package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.Product
import org.example.electroniccomponentretailserver.service.ProductService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController(private val productService: ProductService) {

    @GetMapping
    fun getAllProducts(@PageableDefault(size = 10) pageable: Pageable): Page<Product> = productService.getAllProducts(pageable)

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Int): ResponseEntity<Product> {
        val product = productService.getProductById(id)
        return if (product != null) ResponseEntity.ok(product) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createProduct(@RequestBody product: Product): Product = productService.saveProduct(product)

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Int, @RequestBody updatedProduct: Product): ResponseEntity<Product> {
        val product = productService.updateProduct(id, updatedProduct)
        return if (product != null) ResponseEntity.ok(product) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Int): ResponseEntity<Void> {
        productService.deleteProduct(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/product-status/id/{productStatusId}")
    fun getProductsByProductStatusId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable("productStatusId") productStatusId: Byte): Page<Product> {
        return productService.getProductsByProductStatusId(pageable, productStatusId)
    }

    @GetMapping("/category/id/{categoryId}")
    fun getProductsByCategoryId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable("categoryId") categoryId: Int): Page<Product> {
        return productService.getProductsByCategoryId(pageable, categoryId)
    }

    @GetMapping("/provider/id/{providerId}")
    fun getProductsByProviderId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable("providerId") providerId: Int): Page<Product> {
        return productService.getProductsByProviderId(pageable, providerId)
    }

    @GetMapping("/name")
    fun findProductsByNameContainingIgnoreCase(
        @PageableDefault(size = 10) pageable: Pageable,
        @RequestParam name: String
    ): Page<Product> {
        return productService.findProductsByNameContainingIgnoreCase(pageable, name)
    }
}