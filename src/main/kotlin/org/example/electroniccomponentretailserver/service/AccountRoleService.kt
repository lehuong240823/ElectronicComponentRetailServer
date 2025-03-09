package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.AccountRole
import org.example.electroniccomponentretailserver.repository.AccountRoleRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class AccountRoleService(private val accountRoleRepository: AccountRoleRepository) {

    fun getAllAccountRoles(pageable: Pageable): Page<AccountRole> = accountRoleRepository.findAll(pageable)

    fun getAccountRoleById(id: Byte): AccountRole? = accountRoleRepository.findById(id).orElse(null)

    fun saveAccountRole(role: AccountRole): AccountRole = accountRoleRepository.save(role)

    fun updateAccountRole(id: Byte, updatedAccountRole: AccountRole): AccountRole? {
        return if (accountRoleRepository.existsById(id)) {
            val existingAccountRole: AccountRole = accountRoleRepository.findById(id).get()
            updateEntity(existingAccountRole, updatedAccountRole)
            accountRoleRepository.save(existingAccountRole)
        } else {
            null
        }
    }

    fun deleteAccountRole(id: Byte) = accountRoleRepository.deleteById(id)
}