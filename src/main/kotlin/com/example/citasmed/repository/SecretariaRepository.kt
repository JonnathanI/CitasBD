package com.example.citasmed.repository

import com.example.citasmed.model.Secretaria
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface SecretariaRepository: JpaRepository<Secretaria, Long> {
    fun findById(id:Long?):Optional<Secretaria>
}