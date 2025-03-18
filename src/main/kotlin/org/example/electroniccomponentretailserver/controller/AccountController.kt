package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.Account
import org.example.electroniccomponentretailserver.entity.AccountRole
import org.example.electroniccomponentretailserver.entity.AccountStatus
import org.example.electroniccomponentretailserver.service.AccountService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/accounts")
class AccountController(private val accountService: AccountService) {

    @GetMapping
    fun getAllAccounts(@PageableDefault(size = 10) pageable: Pageable): Page<Account> = accountService.getAllAccounts(pageable)

    @GetMapping("/{id}")
    fun getAccountById(@PathVariable id: Int): ResponseEntity<Account> {
        val account = accountService.getAccountById(id)
        return if (account != null) ResponseEntity.ok(account) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createAccount(@RequestBody account: Account): Account = accountService.saveAccount(account)

    @PutMapping("/{id}")
    fun updateAccount(@PathVariable id: Int, @RequestBody updatedAccount: Account): ResponseEntity<Account> {
        val account = accountService.updateAccount(id, updatedAccount)
        return if (account != null) ResponseEntity.ok(account) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteAccount(@PathVariable id: Int): ResponseEntity<Void> {
        accountService.deleteAccount(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/email/{email}")
    fun getAccountsByEmail(@PageableDefault(size = 10) pageable: Pageable, @PathVariable("email") email: String): Page<Account> {
        return accountService.getAccountsByEmail(pageable, email)
    }

    @GetMapping("/account-role/id/{accountRoleId}")
    fun getAccountsByAccountRoleId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable("accountRoleId") accountRoleId: Byte): Page<Account> {
        return accountService.getAccountsByAccountRoleId(pageable, accountRoleId)
    }

    @GetMapping("/account-status/id/{accountStatusId}")
    fun getAccountsByAccountStatusId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable("accountStatusId") accountStatusId: Byte): Page<Account> {
        return accountService.getAccountsByAccountStatusId(pageable, accountStatusId)
    }
}