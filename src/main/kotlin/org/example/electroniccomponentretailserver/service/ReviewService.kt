package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.Review
import org.example.electroniccomponentretailserver.repository.ReviewRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ReviewService(private val reviewRepository: ReviewRepository) {

    fun getAllReviews(pageable: Pageable): Page<Review> = reviewRepository.findAll(pageable)

    fun getReviewById(id: Int): Review? = reviewRepository.findById(id).orElse(null)

    fun saveReview(role: Review): Review = reviewRepository.save(role)

    fun updateReview(id: Int, updatedReview: Review): Review? {
        return if (reviewRepository.existsById(id)) {
            val existingReview: Review = reviewRepository.findById(id).get()
            updateEntity(existingReview, updatedReview)
            reviewRepository.save(existingReview)
        } else {
            null
        }
    }

    fun deleteReview(id: Int) = reviewRepository.deleteById(id)

    fun getReviewsByOrderItemId(pageable: Pageable, orderItemId: Int): Page<Review> = reviewRepository.findReviewsByOrderItem_Id(pageable, orderItemId)
}