package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.Product
import org.example.electroniccomponentretailserver.service.ProductService
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController(private val productService: ProductService) {

    @GetMapping
    fun getAllProducts(): List<Product> = productService.getAllProducts()

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
}