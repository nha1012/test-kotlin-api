package com.example.restapi.entity

import javax.persistence.*

@Entity
@Table(name = "products")
data class Product(
    @Column(name = "name", nullable = true)
    var name: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    open var id: String? = null
}