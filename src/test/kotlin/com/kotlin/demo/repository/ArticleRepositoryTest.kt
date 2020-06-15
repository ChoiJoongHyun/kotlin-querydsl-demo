package com.kotlin.demo.repository

import com.kotlin.demo.domain.Article
import com.kotlin.demo.domain.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@DataJpaTest
@Transactional
internal class ArticleRepositoryTest @Autowired constructor (
        private val entityManager: EntityManager,
        private val articleRepository: ArticleRepository
) {
    @Test
    fun `특정 사용자가 작성한 게시글 리스트 조회`() {
        var joonghyun = User("joonghyun1", 32)
        entityManager.persist(joonghyun)

        val article = Article(joonghyun, "title", "content")
        entityManager.persist(article)
        entityManager.flush()

        val found = articleRepository.findByAuthorId(joonghyun.id!!)


        assertThat(found.size).isEqualTo(1)
        assertThat(found[0].title).isEqualTo("title")
        assertThat(found[0].author.name).isEqualTo("joonghyun1")
    }
}