package com.mercadolivro.events.listener

import com.mercadolivro.events.PurchaseEvent
import com.mercadolivro.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.*

/*
 *@Component indica para o spring que ele deve gerênciar a classe GenerateNfeListener
 */
@Component
class GenerateNfeListener(
    // Recece no construtor da classe GenerateNfeListener uma PurchaseService
    private val purchaseService: PurchaseService
) {

    /*
     *Toda vez que um evento for disparado, esse ponto de código será disparado
     */
    @Async
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent){
        println("Gerando NFE")
        val nfe = UUID.randomUUID().toString()
        val purchaseModel = purchaseEvent.purchaseModel.copy(nfe = nfe)
        purchaseService.update(purchaseModel)
    }
}