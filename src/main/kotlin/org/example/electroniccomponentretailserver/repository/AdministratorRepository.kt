package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Administrator
import org.springframework.data.jpa.repository.JpaRepository

interface AdministratorRepository : JpaRepository<Administrator, Int> {
}