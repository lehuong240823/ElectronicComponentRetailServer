package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.AccountRole
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRoleRepository: JpaRepository<AccountRole, Byte> {
    override fun findAll(pageable: Pageable): Page<AccountRole>
}