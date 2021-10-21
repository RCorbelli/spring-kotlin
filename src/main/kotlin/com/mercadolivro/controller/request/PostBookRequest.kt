package com.mercadolivro.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import com.mercadolivro.enums.BookStatus
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import java.math.BigDecimal
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class PostBookRequest (
    @field:NotEmpty(message ="Nome deve ser informado")
    var name: String,
    @field:NotNull(message = "Price deve ser informado")
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
