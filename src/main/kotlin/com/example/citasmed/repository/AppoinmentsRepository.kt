package com.example.citasmed.repository

import com.example.citasmed.model.Appoinments
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AppoinmentsRepository: JpaRepository<Appoinments, Long> {
    fun findById(id:Long?): Appoinments
}