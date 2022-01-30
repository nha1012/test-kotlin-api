package com.example.restapi.services

import com.example.restapi.model.CreateProductRequest
import com.example.restapi.model.ListProductRequest
import com.example.restapi.model.ProductResponse
import com.example.restapi.model.WebResponse

interface ProductService {

    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun get(id: String): ProductResponse

    fun list(listProductRequest: ListProductRequest): List<ProductResponse>

    fun update(id: String, updateProductRequest: CreateProductRequest): ProductResponse

    fun delete(id: String)

}