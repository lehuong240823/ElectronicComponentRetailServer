package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.Administrator
import org.example.electroniccomponentretailserver.service.AdministratorService
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/administrators")
class AdministratorController(private val administratorService: AdministratorService) {

    @GetMapping
    fun getAllAdministrators(): List<Administrator> = administratorService.getAllAdministrators()

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
}