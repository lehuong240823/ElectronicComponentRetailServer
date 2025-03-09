package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Provider
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ProviderRepository: JpaRepository<Provider, Int> {
    override fun findAll(pageable: Pageable): Page<Provider>
}