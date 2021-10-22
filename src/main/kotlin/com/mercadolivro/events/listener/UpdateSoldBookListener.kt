package com.mercadolivro.events.listener

import com.mercadolivro.events.PurchaseEvent
import com.mercadolivro.service.BookService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.*

/*
 * Essa classe é responsável por escutar o evento de compra e alterar o status do livro para VENDIDO
 */
@Component //@Component indica para o spring que ele deve gerênciar a classe UpdateSoldBookListener

class UpdateSoldBookListener(

    private val bookService: BookService // Recece no construtor da classe UpdateSoldBookListener uma BookService
) {

    /*
     *Toda vez que um evento for disparado, esse ponto de código será disparado
     */

    @Async // Annotation para indicar que uma função/método deve ser assincrôno
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent){
        println("Atualizando o status do livro")
        bookService.purchase(purchaseEvent.purchaseModel.books)
    }
}