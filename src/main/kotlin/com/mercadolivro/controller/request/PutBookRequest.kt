package com.mercadolivro.controller.request

import java.math.BigDecimal
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class PutBookRequest(
    val name: String?,
    val price: BigDecimal?
) {
}
