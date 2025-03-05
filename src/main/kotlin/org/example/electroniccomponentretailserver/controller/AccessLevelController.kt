package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.AccessLevel
import org.example.electroniccomponentretailserver.service.AccessLevelService
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/access-levels")
class AccessLevelController(private val accessLevelService: AccessLevelService) {

    @GetMapping
    fun getAllAccessLevels(): List<AccessLevel> = accessLevelService.getAllAccessLevels()

    @GetMapping("/{id}")
    fun getAccessLevelById(@PathVariable id: Byte): ResponseEntity<AccessLevel> {
        val accessLevel = accessLevelService.getAccessLevelById(id)
        return if (accessLevel != null) ResponseEntity.ok(accessLevel) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createAccessLevel(@RequestBody accessLevel: AccessLevel): AccessLevel = accessLevelService.saveAccessLevel(accessLevel)

    @PutMapping("/{id}")
    fun updateAccessLevel(@PathVariable id: Byte, @RequestBody updatedAccessLevel: AccessLevel): ResponseEntity<AccessLevel> {
        val accessLevel = accessLevelService.updateAccessLevel(id, updatedAccessLevel)
        return if (accessLevel != null) ResponseEntity.ok(accessLevel) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteAccessLevel(@PathVariable id: Byte): ResponseEntity<Void> {
        accessLevelService.deleteAccessLevel(id)
        return ResponseEntity.noContent().build()
    }
}