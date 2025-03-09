package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.AccountStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface AccountStatusRepository: JpaRepository<AccountStatus, Byte> {
    override fun findAll(pageable: Pageable): Page<AccountStatus>
}