package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Review
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository: JpaRepository<Review, Int> {
    override fun findAll(pageable: Pageable): Page<Review>
    fun findReviewsByOrderItem_Id(pageable: Pageable, orderItemId: Int): Page<Review>
}