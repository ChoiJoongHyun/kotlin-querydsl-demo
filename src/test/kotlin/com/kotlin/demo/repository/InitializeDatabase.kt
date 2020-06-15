package com.kotlin.demo.repository

import com.kotlin.demo.domain.Article
import com.kotlin.demo.domain.User
import javax.persistence.EntityManagerFactory

object InitializeDatabase {

    /**
     * user1 = [ article1, article2, article3 ]
     * user2 = []
     * */
    fun init(entityManagerFactory: EntityManagerFactory) {
        val em = entityManagerFactory.createEntityManager()
        em.transaction.begin()

        val user1 = User("user1", 10)
        val user2 = User("user2", 15, "description")
        em.persist(user1)
        em.persist(user2)

        val article1 = Article(user1, "title1", "content1")
        val article2 = Article(user1, "title2", "content2")
        val article3 = Article(user1, "title3", "content3")
        em.persist(article1)
        em.persist(article2)
        em.persist(article3)
        em.flush()

        em.transaction.commit()

        em.close()
    }

    fun clean(entityManagerFactory: EntityManagerFactory) {
        val em = entityManagerFactory.createEntityManager()
        em.transaction.begin()

        em.createQuery("DELETE FROM Article").executeUpdate()
        em.createQuery("DELETE FROM User").executeUpdate()

        em.transaction.commit()

        em.close()
    }
}


