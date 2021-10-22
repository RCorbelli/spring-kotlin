package com.mercadolivro.service

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.enums.Errors
import com.mercadolivro.events.PurchaseEvent
import com.mercadolivro.exception.BadRequestException
import com.mercadolivro.model.PurchaseModel
import com.mercadolivro.repository.BookRepository
import com.mercadolivro.repository.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository,
    private val bookRepository: BookRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    fun create(purchaseModel: PurchaseModel){
        var names: MutableList<String> = mutableListOf()
        for(book in purchaseModel.books){
            if(book.status == BookStatus.VENDIDO || book.status == BookStatus.DELETADO || book.status == BookStatus.CANCELADO ){
                names += book.name
            }
        }
        if(names.isNotEmpty()){
            throw BadRequestException(Errors.ML103.message.format(names.toString()), Errors.ML103.code)
        }
        purchaseRepository.save(purchaseModel)
        applicationEventPublisher.publishEvent(PurchaseEvent(this, purchaseModel))
    }

    fun update(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
    }

}
