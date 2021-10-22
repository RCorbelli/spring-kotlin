package com.mercadolivro

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync // Importante para ativar os eventos asincrônos.
@SpringBootApplication // Inicializa a aplicação com o SpringBoot
class MercadoLivroApplication

fun main(args: Array<String>) {
	runApplication<MercadoLivroApplication>(*args)
}
