package com.example.citasmed.service

import com.example.citasmed.model.Appoinments
import com.example.citasmed.repository.AppoinmentsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AppoinmentsService {
    @Autowired
    lateinit var appoinmentsRepository: AppoinmentsRepository

    fun list (): List<Appoinments> {
        return appoinmentsRepository.findAll()
    }

    fun save(appoinments: Appoinments): Appoinments {
        return appoinmentsRepository.save(appoinments)
    }

    fun update(appoinments: Appoinments): Appoinments {
        try {
            appoinmentsRepository.findById(appoinments.id?: throw Exception("Consulta no Encontrada"))
            return appoinmentsRepository.save(appoinments)
        }catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateReason(appoinments: Appoinments): Appoinments {
        try {
            val response = appoinmentsRepository.findById(appoinments.id)?: throw Exception("Sintomas Incorrectos")
            response.apply {
                reason = appoinments.reason
            }
            return appoinmentsRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
    fun delete(id: Long) {
        try {
            val response = appoinmentsRepository.findById(id).orElseThrow {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, "Sintomas no Encontrados: $id")
            }
            appoinmentsRepository.delete(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar los Sintomas", ex)
        }
    }

}