package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.Administrator
import org.example.electroniccomponentretailserver.repository.AdministratorRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class AdministratorService(private val administratorRepository: AdministratorRepository) {

    fun getAllAdministrators(pageable: Pageable): Page<Administrator> = administratorRepository.findAll(pageable)

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

    fun getAdministratorsByJobPositionId(pageable: Pageable, jobPositionId: Byte): Page<Administrator> = administratorRepository.findAdministratorsByJobPosition_Id(pageable, jobPositionId)

    fun getAdministratorsByAccessLevelId(pageable: Pageable, accessLevelId: Byte): Page<Administrator> = administratorRepository.findAdministratorsByAccessLevel_Id(pageable, accessLevelId)

    fun getAdministratorsByAccountId(pageable: Pageable, accountId: Int): Page<Administrator> = administratorRepository.findAdministratorsByAccount_Id(pageable, accountId)
}