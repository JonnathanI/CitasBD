package com.example.citasmed.service

import com.example.citasmed.model.Appoinments
import com.example.citasmed.model.Doctor
import com.example.citasmed.model.Secretaria
import com.example.citasmed.repository.AppoinmentsRepository
import com.example.citasmed.repository.DoctorRepository
import com.example.citasmed.repository.SecretariaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class SecretariaService {
    @Autowired
    lateinit var secretariaRepository: SecretariaRepository

    fun list (): List<Secretaria> {
        return secretariaRepository.findAll()
    }

    fun listById(id: Long): Secretaria {
        return secretariaRepository.findById(id)
        .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Secretaria con el $id no Encontrado" )}
    }

    fun save(secretaria: Secretaria): Secretaria {
        return secretariaRepository.save(secretaria)
    }

    fun update(secretaria: Secretaria): Secretaria {
        val existingSecretaria = secretariaRepository.findById(secretaria.id)
            .orElseThrow{ResponseStatusException(HttpStatus.NOT_FOUND , "Secretaria con el ${secretaria.id} no Encontrado" )}
        existingSecretaria.phone = secretaria.phone
        return secretariaRepository.save(existingSecretaria)
    }

    fun updateName(secretaria: Secretaria): Secretaria {
       val existingSecretaria = secretariaRepository.findById(secretaria.id)
           .orElseThrow{ResponseStatusException(HttpStatus.NOT_FOUND,"Secretaria con el ${secretaria.id} no Encontrado" )}
        existingSecretaria.fullName = secretaria.fullName
        return secretariaRepository.save(existingSecretaria)
    }
    fun delete(id: Long) {
      if(!secretariaRepository.existsById(id)){
          throw ResponseStatusException(HttpStatus.NOT_FOUND, "Secretaria con el $id no Encontrado")
      }
        secretariaRepository.deleteById(id)
    }

}