package com.mercadolivro.controller.request

import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.validation.EmailAvailable
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PostCustomerRequest (
    @field:NotEmpty(message = "Nome deve ser informado.")
    var name: String,
    @field:Email(message = "E-mail inválido")
    @EmailAvailable
    var email: String,
    @field:NotEmpty(message = "Senha deve ser informada")
    var password: String,
){
    fun toCustomerModel(): CustomerModel {
        return CustomerModel(
            name = this.name,
            email = this.email,
            status = CustomerStatus.ATIVO,
            password = this.password)
    }
}