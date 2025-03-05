package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.ProductStatus
import org.example.electroniccomponentretailserver.service.ProductStatusService
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/product-statuss")
class ProductStatusController(private val productStatusService: ProductStatusService) {

    @GetMapping
    fun getAllProductStatuss(): List<ProductStatus> = productStatusService.getAllProductStatuss()

    @GetMapping("/{id}")
    fun getProductStatusById(@PathVariable id: Byte): ResponseEntity<ProductStatus> {
        val productStatus = productStatusService.getProductStatusById(id)
        return if (productStatus != null) ResponseEntity.ok(productStatus) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createProductStatus(@RequestBody productStatus: ProductStatus): ProductStatus = productStatusService.saveProductStatus(productStatus)

    @PutMapping("/{id}")
    fun updateProductStatus(@PathVariable id: Byte, @RequestBody updatedProductStatus: ProductStatus): ResponseEntity<ProductStatus> {
        val productStatus = productStatusService.updateProductStatus(id, updatedProductStatus)
        return if (productStatus != null) ResponseEntity.ok(productStatus) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteProductStatus(@PathVariable id: Byte): ResponseEntity<Void> {
        productStatusService.deleteProductStatus(id)
        return ResponseEntity.noContent().build()
    }
}