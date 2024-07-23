package com.example.citasmed.service

import com.example.citasmed.model.Patients
import com.example.citasmed.repository.PatientsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PatientsService {
    @Autowired
    lateinit var patientsRepository: PatientsRepository

    fun list (): List<Patients> {
        return patientsRepository.findAll()
    }

    fun save(patients: Patients): Patients {
        return patientsRepository.save(patients)
    }

    fun update(patients: Patients): Patients {
        try {
            patientsRepository.findById(patients.id?: throw Exception("Paciente no Encontrada"))
            return patientsRepository.save(patients)
        }catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateFullName(patients: Patients): Patients {
        try {
            val response = patientsRepository.findById(patients.id)?: throw Exception("Paciente Incorrectos")
            response.apply {
                fullName = patients.fullName
            }
            return patientsRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
    fun delete(id: Long) {
        try {
            val response = patientsRepository.findById(id).orElseThrow {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente no Encontrados: $id")
            }
            patientsRepository.delete(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el Paciente", ex)
        }
    }

}