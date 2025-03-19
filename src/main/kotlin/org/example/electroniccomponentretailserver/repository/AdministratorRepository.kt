package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Administrator
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface AdministratorRepository: JpaRepository<Administrator, Int> {
    override fun findAll(pageable: Pageable): Page<Administrator>
    fun findAdministratorsByJobPosition_Id(pageable: Pageable, jobPositionId: Byte): Page<Administrator>
    fun findAdministratorsByAccessLevel_Id(pageable: Pageable, accessLevelId: Byte): Page<Administrator>
    fun findAdministratorByAccount_Id(accountId: Int): Optional<Administrator>
}