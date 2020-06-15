package com.kotlin.demo.domain

import javax.persistence.*

@Entity
@Table(name = "article")
class Article (
        user: User,
        title: String,
        content: String?
) : EntityAuditing() {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    var id: Long? = null
        protected set

    @Column(name = "user_id", nullable = false)
    var userId: Long = user.id!!
        protected set

    @Column(name = "title", length = 200, nullable = false)
    var title: String = title
        protected set

    @Column(name = "content", length = 65535)
    var content: String? = content
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    lateinit var user: User
        protected set
}