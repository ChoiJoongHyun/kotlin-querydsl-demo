package com.kotlin.demo.domain

import javax.persistence.*


@Entity
@Table(name = "user")
class User(
        var name: String,
        var age: Int,
        var description: String? = null
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}