package com.kotlin.demo.repository

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import javax.persistence.EntityManagerFactory

@DataJpaTest
internal class UserRepositoryTest @Autowired constructor (
        private val entityManagerFactory: EntityManagerFactory,
        private val userRepository: UserRepository
) {

    @BeforeEach
    fun init() {
        InitializeDatabase.init(entityManagerFactory)
    }

    @Test
    fun `사용자 이름으로 조회`() {
        val found = userRepository.findByName("user1")

        assertThat(found!!.name).isEqualTo("user1")
    }

    @AfterEach
    fun clean() {
        InitializeDatabase.clean(entityManagerFactory)
    }
}