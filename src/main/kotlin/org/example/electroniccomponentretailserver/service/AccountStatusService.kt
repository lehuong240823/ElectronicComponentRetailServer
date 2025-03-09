package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.AccountStatus
import org.example.electroniccomponentretailserver.repository.AccountStatusRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class AccountStatusService(private val accountStatusRepository: AccountStatusRepository) {

    fun getAllAccountStatuss(pageable: Pageable): Page<AccountStatus> = accountStatusRepository.findAll(pageable)

    fun getAccountStatusById(id: Byte): AccountStatus? = accountStatusRepository.findById(id).orElse(null)

    fun saveAccountStatus(role: AccountStatus): AccountStatus = accountStatusRepository.save(role)

    fun updateAccountStatus(id: Byte, updatedAccountStatus: AccountStatus): AccountStatus? {
        return if (accountStatusRepository.existsById(id)) {
            val existingAccountStatus: AccountStatus = accountStatusRepository.findById(id).get()
            updateEntity(existingAccountStatus, updatedAccountStatus)
            accountStatusRepository.save(existingAccountStatus)
        } else {
            null
        }
    }

    fun deleteAccountStatus(id: Byte) = accountStatusRepository.deleteById(id)
}