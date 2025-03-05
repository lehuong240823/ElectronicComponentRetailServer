package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.JobPosition
import org.example.electroniccomponentretailserver.repository.JobPositionRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.stereotype.Service

@Service
class JobPositionService(private val jobPositionRepository: JobPositionRepository) {

    fun getAllJobPositions(): List<JobPosition> = jobPositionRepository.findAll()

    fun getJobPositionById(id: Byte): JobPosition? = jobPositionRepository.findById(id).orElse(null)

    fun saveJobPosition(role: JobPosition): JobPosition = jobPositionRepository.save(role)

    fun updateJobPosition(id: Byte, updatedJobPosition: JobPosition): JobPosition? {
        return if (jobPositionRepository.existsById(id)) {
            val existingJobPosition: JobPosition = jobPositionRepository.findById(id).get()
            updateEntity(existingJobPosition, updatedJobPosition)
            jobPositionRepository.save(existingJobPosition)
        } else {
            null
        }
    }

    fun deleteJobPosition(id: Byte) = jobPositionRepository.deleteById(id)
}