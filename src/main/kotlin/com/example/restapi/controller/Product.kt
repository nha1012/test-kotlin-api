package com.example.restapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class Product {
    @GetMapping(
        value = ["/api/products"],
        produces = ["application/json"]
    )
    fun getProducts(): String{
        return "products"
    }
}