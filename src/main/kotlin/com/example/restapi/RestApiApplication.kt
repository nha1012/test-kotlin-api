package com.example.restapi

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SwaggerKotlinApplication

fun main(args: Array<String>) {
	SpringApplication.run(SwaggerKotlinApplication::class.java, *args)
}