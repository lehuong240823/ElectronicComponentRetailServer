package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.UserAddress
import org.example.electroniccomponentretailserver.service.UserAddressService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user-addresss")
class UserAddressController(private val userAddressService: UserAddressService) {

    @GetMapping
    fun getAllUserAddresss(@PageableDefault(size = 10) pageable: Pageable): Page<UserAddress> = userAddressService.getAllUserAddresss(pageable)

    @GetMapping("/{id}")
    fun getUserAddressById(@PathVariable id: Int): ResponseEntity<UserAddress> {
        val userAddress = userAddressService.getUserAddressById(id)
        return if (userAddress != null) ResponseEntity.ok(userAddress) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createUserAddress(@RequestBody userAddress: UserAddress): UserAddress = userAddressService.saveUserAddress(userAddress)

    @PutMapping("/{id}")
    fun updateUserAddress(@PathVariable id: Int, @RequestBody updatedUserAddress: UserAddress): ResponseEntity<UserAddress> {
        val userAddress = userAddressService.updateUserAddress(id, updatedUserAddress)
        return if (userAddress != null) ResponseEntity.ok(userAddress) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteUserAddress(@PathVariable id: Int): ResponseEntity<Void> {
        userAddressService.deleteUserAddress(id)
        return ResponseEntity.noContent().build()
    }
}