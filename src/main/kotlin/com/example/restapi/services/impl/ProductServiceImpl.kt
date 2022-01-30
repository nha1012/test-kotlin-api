package com.example.restapi.services.impl

import com.example.restapi.Repository.ProductRepository
import com.example.restapi.entity.Product
import com.example.restapi.model.CreateProductRequest
import com.example.restapi.model.ListProductRequest
import com.example.restapi.model.ProductResponse
import com.example.restapi.model.WebResponse
import com.example.restapi.services.ProductService
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class ProductServiceImpl(val productRepository: ProductRepository) : ProductService{
    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        val product = Product(
            name = createProductRequest.name!!
        )
        productRepository.save(product)
        return convertProductToProductResponse(product)
    }

    override fun get(id: String): ProductResponse {
        val product = findProductByIdOrThrowNotFound(id)
        return convertProductToProductResponse(product)
    }

    override fun list(listProductRequest: ListProductRequest): List<ProductResponse> {
        val page = productRepository.findAll(PageRequest.of(listProductRequest.page, listProductRequest.size))
        val products: List<Product> = page.get().collect(Collectors.toList())
        return products.map { convertProductToProductResponse(it) }
    }

    override fun update(id: String, updateProductRequest: CreateProductRequest): ProductResponse {

        val product = findProductByIdOrThrowNotFound(id)
        product.apply {
            name = updateProductRequest.name!!
        }

        productRepository.save(product)
        return convertProductToProductResponse(product)
    }

    override fun delete(id: String) {
        val product = findProductByIdOrThrowNotFound(id)
        productRepository.delete(product)
    }


    private fun findProductByIdOrThrowNotFound(id: String): Product {
        val product = productRepository.findByIdOrNull(id)
        if (product == null) {
            throw ChangeSetPersister.NotFoundException()
        } else {
            return product;
        }
    }

    private fun convertProductToProductResponse(product: Product): ProductResponse {
        return ProductResponse(
            id = product.id,
            name = product.name
        )
    }
}