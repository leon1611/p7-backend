package com.empresa.security.service

import com.empresa.security.model.User
import com.empresa.security.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun list():List<User>?{
        return userRepository.findAll()
    }
}