package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.AccessLevel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface AccessLevelRepository: JpaRepository<AccessLevel, Byte> {
    override fun findAll(pageable: Pageable): Page<AccessLevel>
}