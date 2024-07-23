package com.example.citasmed.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)

    var id: Long? = null
    var username: String? = null
    var password: String? = null
    @OneToMany(mappedBy = "users", fetch = FetchType.EAGER)
    var roles: List<Role>? = null
}