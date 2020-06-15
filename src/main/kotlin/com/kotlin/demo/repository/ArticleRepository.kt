package com.kotlin.demo.repository

import com.kotlin.demo.domain.Article
import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long> {

    fun findByAuthorId(userId : Long): List<Article>
}