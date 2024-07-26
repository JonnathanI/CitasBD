package com.example.citasmed.model

import jakarta.persistence.*

@Entity
@Table(name = "secretaria")
class Secretaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null
    @Column(name = "fullname")
    var fullName: String? = null
    var phone: String? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    var doctor: Doctor? = null
}