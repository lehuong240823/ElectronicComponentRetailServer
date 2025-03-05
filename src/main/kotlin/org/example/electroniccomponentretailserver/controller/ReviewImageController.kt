package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.ReviewImage
import org.example.electroniccomponentretailserver.service.ReviewImageService
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/review-images")
class ReviewImageController(private val reviewImageService: ReviewImageService) {

    @GetMapping
    fun getAllReviewImages(): List<ReviewImage> = reviewImageService.getAllReviewImages()

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