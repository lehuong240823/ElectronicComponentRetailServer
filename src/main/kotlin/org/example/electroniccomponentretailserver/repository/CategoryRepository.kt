package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Category
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository: JpaRepository<Category, Int> {
    override fun findAll(pageable: Pageable): Page<Category>
}