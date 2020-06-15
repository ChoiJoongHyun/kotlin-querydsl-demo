package com.kotlin.demo.service

import org.springframework.stereotype.Service

@Service
class UserService {

    fun getUser(): String {
        return "choi joong hyun";
    }
}