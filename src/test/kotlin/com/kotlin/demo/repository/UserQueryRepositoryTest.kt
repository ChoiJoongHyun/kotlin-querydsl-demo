package com.kotlin.demo.repository


import com.querydsl.jpa.impl.JPAQueryFactory
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import javax.persistence.EntityManagerFactory

@DataJpaTest
internal class UserQueryRepositoryTest @Autowired constructor (
        private val entityManagerFactory: EntityManagerFactory
) {

    private val userQueryRepository: UserQueryRepository = UserQueryRepository(JPAQueryFactory(entityManagerFactory.createEntityManager()))

    @BeforeEach
    fun init() {
        InitializeDatabase.init(entityManagerFactory)
    }

    @Test
    fun `사용자 이름으로 조회`() {
        val found = userQueryRepository.findByName("user2")
        Assertions.assertThat(found?.name).isEqualTo("user2")
    }

    @AfterEach
    fun clean() {
        InitializeDatabase.clean(entityManagerFactory)
    }
}
