package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Administrator
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface AdministratorRepository: JpaRepository<Administrator, Int> {
    override fun findAll(pageable: Pageable): Page<Administrator>
    fun findAdministratorsByJobPosition_Id(pageable: Pageable, jobPositionId: Byte): Page<Administrator>
    fun findAdministratorsByAccessLevel_Id(pageable: Pageable, accessLevelId: Byte): Page<Administrator>
    fun findAdministratorsByAccount_Id(pageable: Pageable, accountId: Int): Page<Administrator>
}