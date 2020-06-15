package com.kotlin.demo.repository

import com.kotlin.demo.domain.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {

    fun findByName(name: String): User?

}