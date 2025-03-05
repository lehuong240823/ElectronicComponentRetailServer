package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Provider
import org.springframework.data.jpa.repository.JpaRepository

interface ProviderRepository : JpaRepository<Provider, Int> {
}