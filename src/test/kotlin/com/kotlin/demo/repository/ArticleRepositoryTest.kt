package com.kotlin.demo.repository

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import javax.persistence.EntityManagerFactory

@DataJpaTest
internal class ArticleRepositoryTest @Autowired constructor (
        private val entityManagerFactory: EntityManagerFactory,
        private val articleRepository: ArticleRepository,
        private val userRepository: UserRepository
) {

    @BeforeEach
    fun init() {
        InitializeDatabase.init(entityManagerFactory)
    }

    @Test
    fun `특정 사용자가 작성한 게시글 리스트 조회`() {
        var user = userRepository.findByName("user1")

        val articleList = articleRepository.findByUserId(user!!.id!!)

        assertThat(articleList.size).isEqualTo(3)

        for(article in articleList) {
            assertThat(article.user.name).isEqualTo("user1")
        }
    }

    @AfterEach
    fun clean() {
        InitializeDatabase.clean(entityManagerFactory)
    }
}