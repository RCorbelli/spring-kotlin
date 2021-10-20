package com.mercadolivro.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import com.mercadolivro.enums.BookStatus
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import java.math.BigDecimal

data class PostBookRequest (
    var name: String,
    var price: BigDecimal,

    @JsonAlias("customer_id")
    var customerId: Int
){
    fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
        return BookModel(
                name = this.name,
                price = this.price,
                status = BookStatus.ATIVO,
                customer = customer

        )
    }
}
