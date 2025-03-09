package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.AccessLevel
import org.example.electroniccomponentretailserver.repository.AccessLevelRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class AccessLevelService(private val accessLevelRepository: AccessLevelRepository) {

    fun getAllAccessLevels(pageable: Pageable): Page<AccessLevel> = accessLevelRepository.findAll(pageable)

    fun getAccessLevelById(id: Byte): AccessLevel? = accessLevelRepository.findById(id).orElse(null)

    fun saveAccessLevel(role: AccessLevel): AccessLevel = accessLevelRepository.save(role)

    fun updateAccessLevel(id: Byte, updatedAccessLevel: AccessLevel): AccessLevel? {
        return if (accessLevelRepository.existsById(id)) {
            val existingAccessLevel: AccessLevel = accessLevelRepository.findById(id).get()
            updateEntity(existingAccessLevel, updatedAccessLevel)
            accessLevelRepository.save(existingAccessLevel)
        } else {
            null
        }
    }

    fun deleteAccessLevel(id: Byte) = accessLevelRepository.deleteById(id)
}