package com.empresa.security.repository

import com.empresa.security.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {


}