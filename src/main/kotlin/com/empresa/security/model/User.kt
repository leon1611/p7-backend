package com.empresa.security.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "users")
class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var username: String? = null
    var email: String? = null
    @Column(name = "password_hash")
    var passwordHash: String? = null
    @Column(name = "is_active")
    var isActive: String? = null
    @Column(name = "created_at")
    var createdAt: String? = null
}