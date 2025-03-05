package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.Category
import org.example.electroniccomponentretailserver.service.CategoryService
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/categorys")
class CategoryController(private val categoryService: CategoryService) {

    @GetMapping
    fun getAllCategorys(): List<Category> = categoryService.getAllCategorys()

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: Int): ResponseEntity<Category> {
        val category = categoryService.getCategoryById(id)
        return if (category != null) ResponseEntity.ok(category) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createCategory(@RequestBody category: Category): Category = categoryService.saveCategory(category)

    @PutMapping("/{id}")
    fun updateCategory(@PathVariable id: Int, @RequestBody updatedCategory: Category): ResponseEntity<Category> {
        val category = categoryService.updateCategory(id, updatedCategory)
        return if (category != null) ResponseEntity.ok(category) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: Int): ResponseEntity<Void> {
        categoryService.deleteCategory(id)
        return ResponseEntity.noContent().build()
    }
}