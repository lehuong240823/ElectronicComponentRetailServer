package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.ReviewImage
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewImageRepository : JpaRepository<ReviewImage, Int> {
}