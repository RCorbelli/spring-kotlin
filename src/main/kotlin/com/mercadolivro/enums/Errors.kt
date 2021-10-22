package com.mercadolivro.enums

enum class Errors (val code: String, val message: String) {

    MLR001("MLR-001", "Invalid request"),

    ML000("ML-000", "Access Denied"),

    ML100("ML-100", "Book [%s] not exists"),
    ML102("ML-102", "Cannot update book with status: [%s]"),
    ML103("ML-103", "Os livros [%s] não estão disponíveis"),


    ML200("ML-200", "Customer [%s] not exists")
}