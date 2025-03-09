package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.Provider
import org.example.electroniccomponentretailserver.repository.ProviderRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProviderService(private val providerRepository: ProviderRepository) {

    fun getAllProviders(pageable: Pageable): Page<Provider> = providerRepository.findAll(pageable)

    fun getProviderById(id: Int): Provider? = providerRepository.findById(id).orElse(null)

    fun saveProvider(role: Provider): Provider = providerRepository.save(role)

    fun updateProvider(id: Int, updatedProvider: Provider): Provider? {
        return if (providerRepository.existsById(id)) {
            val existingProvider: Provider = providerRepository.findById(id).get()
            updateEntity(existingProvider, updatedProvider)
            providerRepository.save(existingProvider)
        } else {
            null
        }
    }

    fun deleteProvider(id: Int) = providerRepository.deleteById(id)
}