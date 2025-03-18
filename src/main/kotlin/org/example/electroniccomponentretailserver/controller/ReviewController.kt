package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.Review
import org.example.electroniccomponentretailserver.service.ReviewService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/reviews")
class ReviewController(private val reviewService: ReviewService) {

    @GetMapping
    fun getAllReviews(@PageableDefault(size = 10) pageable: Pageable): Page<Review> = reviewService.getAllReviews(pageable)

    @GetMapping("/{id}")
    fun getReviewById(@PathVariable id: Int): ResponseEntity<Review> {
        val review = reviewService.getReviewById(id)
        return if (review != null) ResponseEntity.ok(review) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createReview(@RequestBody review: Review): Review = reviewService.saveReview(review)

    @PutMapping("/{id}")
    fun updateReview(@PathVariable id: Int, @RequestBody updatedReview: Review): ResponseEntity<Review> {
        val review = reviewService.updateReview(id, updatedReview)
        return if (review != null) ResponseEntity.ok(review) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteReview(@PathVariable id: Int): ResponseEntity<Void> {
        reviewService.deleteReview(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/order-item/id/{orderItemId}")
    fun getReviewsByOrderItemId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable("orderItemId") orderItemId: Int): Page<Review> {
        return reviewService.getReviewsByOrderItemId(pageable, orderItemId)
    }
}