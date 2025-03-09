package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.ReviewImage
import org.example.electroniccomponentretailserver.repository.ReviewImageRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ReviewImageService(private val reviewImageRepository: ReviewImageRepository) {

    fun getAllReviewImages(pageable: Pageable): Page<ReviewImage> = reviewImageRepository.findAll(pageable)

    fun getReviewImageById(id: Int): ReviewImage? = reviewImageRepository.findById(id).orElse(null)

    fun saveReviewImage(role: ReviewImage): ReviewImage = reviewImageRepository.save(role)

    fun updateReviewImage(id: Int, updatedReviewImage: ReviewImage): ReviewImage? {
        return if (reviewImageRepository.existsById(id)) {
            val existingReviewImage: ReviewImage = reviewImageRepository.findById(id).get()
            updateEntity(existingReviewImage, updatedReviewImage)
            reviewImageRepository.save(existingReviewImage)
        } else {
            null
        }
    }

    fun deleteReviewImage(id: Int) = reviewImageRepository.deleteById(id)
}