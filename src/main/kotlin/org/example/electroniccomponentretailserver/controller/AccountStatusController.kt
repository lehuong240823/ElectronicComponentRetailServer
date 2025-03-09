package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.AccountStatus
import org.example.electroniccomponentretailserver.service.AccountStatusService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/account-statuss")
class AccountStatusController(private val accountStatusService: AccountStatusService) {

    @GetMapping
    fun getAllAccountStatuss(@PageableDefault(size = 10) pageable: Pageable): Page<AccountStatus> = accountStatusService.getAllAccountStatuss(pageable)

    @GetMapping("/{id}")
    fun getAccountStatusById(@PathVariable id: Byte): ResponseEntity<AccountStatus> {
        val accountStatus = accountStatusService.getAccountStatusById(id)
        return if (accountStatus != null) ResponseEntity.ok(accountStatus) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createAccountStatus(@RequestBody accountStatus: AccountStatus): AccountStatus = accountStatusService.saveAccountStatus(accountStatus)

    @PutMapping("/{id}")
    fun updateAccountStatus(@PathVariable id: Byte, @RequestBody updatedAccountStatus: AccountStatus): ResponseEntity<AccountStatus> {
        val accountStatus = accountStatusService.updateAccountStatus(id, updatedAccountStatus)
        return if (accountStatus != null) ResponseEntity.ok(accountStatus) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteAccountStatus(@PathVariable id: Byte): ResponseEntity<Void> {
        accountStatusService.deleteAccountStatus(id)
        return ResponseEntity.noContent().build()
    }
}