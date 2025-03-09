package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.Provider
import org.example.electroniccomponentretailserver.service.ProviderService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/providers")
class ProviderController(private val providerService: ProviderService) {

    @GetMapping
    fun getAllProviders(@PageableDefault(size = 10) pageable: Pageable): Page<Provider> = providerService.getAllProviders(pageable)

    @GetMapping("/{id}")
    fun getProviderById(@PathVariable id: Int): ResponseEntity<Provider> {
        val provider = providerService.getProviderById(id)
        return if (provider != null) ResponseEntity.ok(provider) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createProvider(@RequestBody provider: Provider): Provider = providerService.saveProvider(provider)

    @PutMapping("/{id}")
    fun updateProvider(@PathVariable id: Int, @RequestBody updatedProvider: Provider): ResponseEntity<Provider> {
        val provider = providerService.updateProvider(id, updatedProvider)
        return if (provider != null) ResponseEntity.ok(provider) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteProvider(@PathVariable id: Int): ResponseEntity<Void> {
        providerService.deleteProvider(id)
        return ResponseEntity.noContent().build()
    }
}