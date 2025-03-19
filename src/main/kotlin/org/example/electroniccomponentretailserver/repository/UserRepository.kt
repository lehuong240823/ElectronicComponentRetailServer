package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository: JpaRepository<User, Int> {
    override fun findAll(pageable: Pageable): Page<User>
    fun findUserByAccount_Id(accountId: Int): Optional<User>
}