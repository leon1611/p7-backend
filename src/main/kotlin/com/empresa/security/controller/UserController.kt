package com.empresa.security.controller

import com.empresa.security.model.User
import com.empresa.security.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT], origins = ["http://localhost:3000"] )
class UserController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping
    fun login():ResponseEntity<*>{

        return userService.list()?.let {
            ResponseEntity(it, HttpStatus.OK)
            } ?: ResponseEntity<User>( HttpStatus.NOT_FOUND)
    }
}