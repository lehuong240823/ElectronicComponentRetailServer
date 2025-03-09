package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.ReviewImage
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewImageRepository: JpaRepository<ReviewImage, Int> {
    override fun findAll(pageable: Pageable): Page<ReviewImage>
}