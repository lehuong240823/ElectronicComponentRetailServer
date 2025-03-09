package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Administrator
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface AdministratorRepository: JpaRepository<Administrator, Int> {
    override fun findAll(pageable: Pageable): Page<Administrator>
}