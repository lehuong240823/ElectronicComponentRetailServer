package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.AccountRole
import org.example.electroniccomponentretailserver.service.AccountRoleService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/account-roles")
class AccountRoleController(private val accountRoleService: AccountRoleService) {

    @GetMapping
    fun getAllAccountRoles(@PageableDefault(size = 10) pageable: Pageable): Page<AccountRole> = accountRoleService.getAllAccountRoles(pageable)

    @GetMapping("/{id}")
    fun getAccountRoleById(@PathVariable id: Byte): ResponseEntity<AccountRole> {
        val accountRole = accountRoleService.getAccountRoleById(id)
        return if (accountRole != null) ResponseEntity.ok(accountRole) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createAccountRole(@RequestBody accountRole: AccountRole): AccountRole = accountRoleService.saveAccountRole(accountRole)

    @PutMapping("/{id}")
    fun updateAccountRole(@PathVariable id: Byte, @RequestBody updatedAccountRole: AccountRole): ResponseEntity<AccountRole> {
        val accountRole = accountRoleService.updateAccountRole(id, updatedAccountRole)
        return if (accountRole != null) ResponseEntity.ok(accountRole) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteAccountRole(@PathVariable id: Byte): ResponseEntity<Void> {
        accountRoleService.deleteAccountRole(id)
        return ResponseEntity.noContent().build()
    }
}