package com.mercadolivro.controller.request

import com.mercadolivro.model.CustomerModel

data class PutCustomerRequest (
    var name: String,
    var email: String
) {
    fun toCustomerModel(id: Int): CustomerModel {
        return CustomerModel(id = id, name = this.name, email = this.email)
    }
}