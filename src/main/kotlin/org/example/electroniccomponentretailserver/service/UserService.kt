package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.User
import org.example.electroniccomponentretailserver.repository.UserRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(pageable: Pageable): Page<User> = userRepository.findAll(pageable)

    fun getUserById(id: Int): User? = userRepository.findById(id).orElse(null)

    fun saveUser(role: User): User = userRepository.save(role)

    fun updateUser(id: Int, updatedUser: User): User? {
        return if (userRepository.existsById(id)) {
            val existingUser: User = userRepository.findById(id).get()
            updateEntity(existingUser, updatedUser)
            userRepository.save(existingUser)
        } else {
            null
        }
    }

    fun deleteUser(id: Int) = userRepository.deleteById(id)

    fun getUsersByAccountId(pageable: Pageable, accountId: Int): Page<User> = userRepository.findUsersByAccount_Id(pageable, accountId)
}