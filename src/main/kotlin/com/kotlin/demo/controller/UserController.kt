package com.kotlin.demo.controller

import com.kotlin.demo.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController (
        private val userService: UserService
) {

    @GetMapping("/users")
    fun getUser(): String {
        return userService.getUser()
    }
}
