package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Account
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository: JpaRepository<Account, Int> {
    override fun findAll(pageable: Pageable): Page<Account>
}