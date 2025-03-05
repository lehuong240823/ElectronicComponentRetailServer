package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository : JpaRepository<Review, Int> {
}