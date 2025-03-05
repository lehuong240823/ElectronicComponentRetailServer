package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int> {
}