package com.example.citasmed.service

import com.example.citasmed.model.Doctor
import com.example.citasmed.repository.DoctorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class DoctorService {
    @Autowired
    lateinit var doctorRepository: DoctorRepository

    fun list (): List<Doctor> {
        return doctorRepository.findAll()
    }

    fun save(doctor: Doctor): Doctor {
        return doctorRepository.save(doctor)
    }

    fun update(doctor: Doctor): Doctor {
        try {
            doctorRepository.findById(doctor.id?: throw Exception("Doctor no Encontrada"))
            return doctorRepository.save(doctor)
        }catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(doctor: Doctor): Doctor {
        try {
            val response = doctorRepository.findById(doctor.id)?: throw Exception("Doctor Incorrectos")
            response.apply {
                fullName = doctor.fullName
            }
            return doctorRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
    fun delete(id: Long) {
        try {
            val response = doctorRepository.findById(id).orElseThrow {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor no Encontrados: $id")
            }
            doctorRepository.delete(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el Doctor", ex)
        }
    }

}