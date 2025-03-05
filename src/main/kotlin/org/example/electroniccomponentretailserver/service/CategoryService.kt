package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.Category
import org.example.electroniccomponentretailserver.repository.CategoryRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.stereotype.Service

@Service
class CategoryService(private val categoryRepository: CategoryRepository) {

    fun getAllCategorys(): List<Category> = categoryRepository.findAll()

    fun getCategoryById(id: Int): Category? = categoryRepository.findById(id).orElse(null)

    fun saveCategory(role: Category): Category = categoryRepository.save(role)

    fun updateCategory(id: Int, updatedCategory: Category): Category? {
        return if (categoryRepository.existsById(id)) {
            val existingCategory: Category = categoryRepository.findById(id).get()
            updateEntity(existingCategory, updatedCategory)
            categoryRepository.save(existingCategory)
        } else {
            null
        }
    }

    fun deleteCategory(id: Int) = categoryRepository.deleteById(id)
}