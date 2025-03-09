package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.JobPosition
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface JobPositionRepository: JpaRepository<JobPosition, Byte> {
    override fun findAll(pageable: Pageable): Page<JobPosition>
}