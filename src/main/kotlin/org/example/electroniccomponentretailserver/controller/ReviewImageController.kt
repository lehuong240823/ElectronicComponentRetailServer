package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.ReviewImage
import org.example.electroniccomponentretailserver.service.ReviewImageService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/review-images")
class ReviewImageController(private val reviewImageService: ReviewImageService) {

    @GetMapping
    fun getAllReviewImages(@PageableDefault(size = 10) pageable: Pageable): Page<ReviewImage> = reviewImageService.getAllReviewImages(pageable)

    @GetMapping("/{id}")
    fun getReviewImageById(@PathVariable id: Int): ResponseEntity<ReviewImage> {
        val reviewImage = reviewImageService.getReviewImageById(id)
        return if (reviewImage != null) ResponseEntity.ok(reviewImage) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createReviewImage(@RequestBody reviewImage: ReviewImage): ReviewImage = reviewImageService.saveReviewImage(reviewImage)

    @PutMapping("/{id}")
    fun updateReviewImage(@PathVariable id: Int, @RequestBody updatedReviewImage: ReviewImage): ResponseEntity<ReviewImage> {
        val reviewImage = reviewImageService.updateReviewImage(id, updatedReviewImage)
        return if (reviewImage != null) ResponseEntity.ok(reviewImage) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteReviewImage(@PathVariable id: Int): ResponseEntity<Void> {
        reviewImageService.deleteReviewImage(id)
        return ResponseEntity.noContent().build()
    }
}