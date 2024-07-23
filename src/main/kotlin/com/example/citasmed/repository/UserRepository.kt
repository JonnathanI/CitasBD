package com.example.citasmed.repository

import com.example.citasmed.model.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<Users, String> {
    fun findByUsername(username:String): Users?
}