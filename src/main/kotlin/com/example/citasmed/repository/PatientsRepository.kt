package com.example.citasmed.repository

import com.example.citasmed.model.Patients
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PatientsRepository: JpaRepository<Patients, Long> {
    fun findById(id:Long?): Patients
}