package com.mercadolivro.service

import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.enums.Role
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.util.*

@ExtendWith(MockKExtension::class)
class CustomerServiceTest{

    @MockK
    lateinit var customerRepository: CustomerRepository
    @MockK
    lateinit var bookService: BookService
    @MockK
    lateinit var bCrypt: BCryptPasswordEncoder

    @InjectMockKs
    private lateinit var customerService: CustomerService

    @Test
    fun `should return all customers`(){
        val customer1 = buildCustomer();
        val fakeCustomers = listOf(buildCustomer(), buildCustomer())

        every{customerRepository.findAll()} returns fakeCustomers

        val customers = customerService.getAll(null)

        assertEquals(fakeCustomers, customers)
        verify(exactly = 1) { customerRepository.findAll() }
        verify(exactly = 0) { customerRepository.findByNameContaining(any()) }
    }

    fun buildCustomer(
        id: Int? = null,
        name: String = "Customer Name",
        email: String = "${UUID.randomUUID()}@email.com",
        password: String = "password"
        ) = CustomerModel(
            id= id,
            name=name,
            email = email,
            status = CustomerStatus.ATIVO,
            password = password,
            roles = setOf(Role.CUSTOMER)
        )
}