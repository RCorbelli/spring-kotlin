package com.mercadolivro.controller.request

import com.mercadolivro.model.CustomerModel
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PutCustomerRequest (
    @field:NotEmpty
    var name: String,
    @field: Email
    var email: String
) {
    fun toCustomerModel(previusValue: CustomerModel): CustomerModel {
        return CustomerModel(id = previusValue.id, name = this.name, email = this.email, status = previusValue.status)
    }
}