package com.mercadolivro.extension

import com.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.controller.request.PutBookRequest
import com.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.controller.response.BookResponse
import com.mercadolivro.controller.response.CustomerResponse
import com.mercadolivro.enums.BookStatus
import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.model.BookModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email, status = CustomerStatus.ATIVO)
}

fun PutCustomerRequest.toCustomerModel(previusValue: CustomerModel): CustomerModel {
    return CustomerModel(name = this.name, email = this.email, status = previusValue.status)
}
fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
            name = this.name,
            price = this.price,
            status = BookStatus.ATIVO,
            customer = customer
    )
}

fun PutBookRequest.toBookModel(previusValue: BookResponse): BookModel {
    return BookModel(
        id = previusValue.id,
        name = this.name ?: previusValue.name,
        price = this.price ?: previusValue.price,
        status = previusValue.status,
        customer = previusValue.customer

    )
}

fun CustomerModel.toResponse(): CustomerResponse{
    return CustomerResponse(id = this.id, name = this.name, email = this.email, status = this.status)
}

fun BookModel.toResponse(): BookResponse{
    return BookResponse(id = this.id, name = this.name, price = this.price, customer = this.customer, status = this.status)
}