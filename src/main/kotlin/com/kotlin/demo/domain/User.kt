package com.kotlin.demo.domain

import javax.persistence.*

@Entity
@Table(name = "user")
class User(
        name: String,
        age: Int,
        description: String? = null
) : EntityAuditing() {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    var id: Long? = null
        protected set

    @Column(name = "name", length = 200, nullable = false)
    var name: String = name
        protected set

    @Column(name = "age", length = 200, nullable = false)
    var age: Int = age
        protected set

    @Column(name = "desc", length = 3000)
    var description: String? = description
        protected set
}