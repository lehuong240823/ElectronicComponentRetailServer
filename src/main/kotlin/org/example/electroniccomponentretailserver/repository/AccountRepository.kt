package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Account
import org.example.electroniccomponentretailserver.entity.AccountRole
import org.example.electroniccomponentretailserver.entity.AccountStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface AccountRepository: JpaRepository<Account, Int> {
    override fun findAll(pageable: Pageable): Page<Account>
    fun findAccountsByEmail(pageable: Pageable, email: String): Page<Account>
    fun findAccountsByAccountRole_Id(pageable: Pageable, accountRoleId: Byte): Page<Account>
    fun findAccountsByAccountStatus_Id(pageable: Pageable, accountStatusId: Byte): Page<Account>
}