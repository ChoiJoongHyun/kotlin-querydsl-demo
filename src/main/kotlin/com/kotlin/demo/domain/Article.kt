package com.kotlin.demo.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "article")
class Article(
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id", insertable = false, updatable = false)
        var author: User,
        var title: String,
        var content: String,
        var addedAt: LocalDateTime? = LocalDateTime.now()
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}