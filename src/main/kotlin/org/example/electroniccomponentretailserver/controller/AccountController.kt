package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.Account
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
    fun getAccountByEmail(@PathVariable("email") email: String): ResponseEntity<Account> {
        val account = accountService.getAccountByEmail(email)
        return if (account != null) ResponseEntity.ok(account) else ResponseEntity.notFound().build()
    }
}