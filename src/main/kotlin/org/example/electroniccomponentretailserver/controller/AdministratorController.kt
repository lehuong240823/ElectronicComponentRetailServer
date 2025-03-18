package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.Administrator
import org.example.electroniccomponentretailserver.service.AdministratorService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/administrators")
class AdministratorController(private val administratorService: AdministratorService) {

    @GetMapping
    fun getAllAdministrators(@PageableDefault(size = 10) pageable: Pageable): Page<Administrator> = administratorService.getAllAdministrators(pageable)

    @GetMapping("/{id}")
    fun getAdministratorById(@PathVariable id: Int): ResponseEntity<Administrator> {
        val administrator = administratorService.getAdministratorById(id)
        return if (administrator != null) ResponseEntity.ok(administrator) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createAdministrator(@RequestBody administrator: Administrator): Administrator = administratorService.saveAdministrator(administrator)

    @PutMapping("/{id}")
    fun updateAdministrator(@PathVariable id: Int, @RequestBody updatedAdministrator: Administrator): ResponseEntity<Administrator> {
        val administrator = administratorService.updateAdministrator(id, updatedAdministrator)
        return if (administrator != null) ResponseEntity.ok(administrator) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteAdministrator(@PathVariable id: Int): ResponseEntity<Void> {
        administratorService.deleteAdministrator(id)
        return ResponseEntity.noContent().build()
    }


    @GetMapping("/job-position/id/{jobPositionId}")
    fun getAdministratorsByJobPositionId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable("jobPositionId") jobPositionId: Byte): Page<Administrator> {
        return administratorService.getAdministratorsByJobPositionId(pageable, jobPositionId)
    }

    @GetMapping("/access-level/id/{accessLevelId}")
    fun getAdministratorsByAccessLevelId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable("accessLevelId") accessLevelId: Byte): Page<Administrator> {
        return administratorService.getAdministratorsByAccessLevelId(pageable, accessLevelId)
    }

    @GetMapping("/account/id/{accountId}")
    fun getAdministratorsByAccountId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable("accountId") accountId: Int): Page<Administrator> {
        return administratorService.getAdministratorsByAccountId(pageable, accountId)
    }
}