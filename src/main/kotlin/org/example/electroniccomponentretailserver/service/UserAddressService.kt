package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.UserAddress
import org.example.electroniccomponentretailserver.repository.UserAddressRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class UserAddressService(private val userAddressRepository: UserAddressRepository) {

    fun getAllUserAddresses(pageable: Pageable): Page<UserAddress> = userAddressRepository.findAll(pageable)

    fun getUserAddressById(id: Int): UserAddress? = userAddressRepository.findById(id).orElse(null)

    fun saveUserAddress(role: UserAddress): UserAddress = userAddressRepository.save(role)

    fun updateUserAddress(id: Int, updatedUserAddress: UserAddress): UserAddress? {
        return if (userAddressRepository.existsById(id)) {
            val existingUserAddress: UserAddress = userAddressRepository.findById(id).get()
            updateEntity(existingUserAddress, updatedUserAddress)
            userAddressRepository.save(existingUserAddress)
        } else {
            null
        }
    }

    fun deleteUserAddress(id: Int) = userAddressRepository.deleteById(id)

    fun getUserAddressesByUserId(pageable: Pageable, userId: Int): Page<UserAddress> = userAddressRepository.findUserAddressesByUser_Id(pageable, userId)
}