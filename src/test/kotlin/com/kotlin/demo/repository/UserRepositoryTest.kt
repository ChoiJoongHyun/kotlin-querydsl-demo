package com.kotlin.demo.repository

import com.kotlin.demo.domain.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@DataJpaTest
@Transactional
internal class UserRepositoryTest @Autowired constructor (
        private val entityManager: EntityManager,
        private val userRepository: UserRepository
) {
    @Test
    fun `사용자 이름으로 조회`() {
        var joonghyun = User("joonghyun3", 32)
        entityManager.persist(joonghyun)
        entityManager.flush()

        val found = userRepository.findByName("joonghyun3")

        assertThat(found!!.name).isEqualTo("joonghyun3")
    }
}