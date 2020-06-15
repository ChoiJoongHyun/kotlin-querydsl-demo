package com.kotlin.demo.repository

import com.kotlin.demo.domain.QUser.*
import com.kotlin.demo.domain.User
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository

@Repository
class UserQueryRepository (
    private val jpaQueryFactory: JPAQueryFactory
) {
    fun findByName(name: String): User? {
        return jpaQueryFactory.selectFrom(user)
                .where(user.name.eq(name))
                .fetchOne()
    }
}