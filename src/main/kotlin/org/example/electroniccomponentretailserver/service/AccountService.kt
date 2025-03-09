package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.Account
import org.example.electroniccomponentretailserver.repository.AccountRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class AccountService(private val accountRepository: AccountRepository) {

    fun getAllAccounts(pageable: Pageable): Page<Account> = accountRepository.findAll(pageable)

    fun getAccountById(id: Int): Account? = accountRepository.findById(id).orElse(null)

    fun saveAccount(role: Account): Account = accountRepository.save(role)

    fun updateAccount(id: Int, updatedAccount: Account): Account? {
        return if (accountRepository.existsById(id)) {
            val existingAccount: Account = accountRepository.findById(id).get()
            updateEntity(existingAccount, updatedAccount)
            accountRepository.save(existingAccount)
        } else {
            null
        }
    }

    fun deleteAccount(id: Int) = accountRepository.deleteById(id)

    fun getAccountByEmail(email: String): Account? = accountRepository.findAccountByEmail(email).orElse(null)
}