package com.kotlin.demo.repository


import com.kotlin.demo.domain.User
import com.querydsl.jpa.impl.JPAQueryFactory
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager


@DataJpaTest
@Transactional
internal class UserQueryRepositoryTest @Autowired constructor (
        private val entityManager: EntityManager
) {

    private val userQueryRepository: UserQueryRepository = UserQueryRepository(JPAQueryFactory(entityManager))

    @Test
    fun `사용자 이름으로 조회`() {
        var joonghyun = User("joonghyun2", 32)
        entityManager.persist(joonghyun)
        entityManager.flush()

        val found = userQueryRepository.findByName("joonghyun2")

        Assertions.assertThat(found?.name).isEqualTo("joonghyun2")
    }
}
