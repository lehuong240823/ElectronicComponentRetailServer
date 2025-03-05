package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.Administrator
import org.example.electroniccomponentretailserver.repository.AdministratorRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.stereotype.Service

@Service
class AdministratorService(private val administratorRepository: AdministratorRepository) {

    fun getAllAdministrators(): List<Administrator> = administratorRepository.findAll()

    fun getAdministratorById(id: Int): Administrator? = administratorRepository.findById(id).orElse(null)

    fun saveAdministrator(role: Administrator): Administrator = administratorRepository.save(role)

    fun updateAdministrator(id: Int, updatedAdministrator: Administrator): Administrator? {
        return if (administratorRepository.existsById(id)) {
            val existingAdministrator: Administrator = administratorRepository.findById(id).get()
            updateEntity(existingAdministrator, updatedAdministrator)
            administratorRepository.save(existingAdministrator)
        } else {
            null
        }
    }

    fun deleteAdministrator(id: Int) = administratorRepository.deleteById(id)
}