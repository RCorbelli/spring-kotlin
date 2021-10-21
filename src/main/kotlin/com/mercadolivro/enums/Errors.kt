package com.mercadolivro.enums

enum class Errors (val code: String, val message: String) {

    MLR001("MLR-001", "Invalid request"),


    ML100("ML-100", "Book [%s] not exists"),
    ML102("ML-102", "Cannot update book with status: [%s]"),


    ML200("ML-200", "Customer [%s] not exists")
}