package me.jincrates.reactivekotlin.customer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class CustomerServiceImpl : CustomerService {
    @Autowired
    lateinit var customerRepository: CustomerRepository

    override fun getCustomer(id: Int) = customerRepository.findById(id)
    override fun createCustomer(customerMono: Mono<Customer>): Mono<Customer> = customerRepository.create(customerMono)
    override fun deleteCustomer(id: Int): Mono<Boolean> = customerRepository.deleteById(id).map { it.deletedCount > 0 }
    override fun searchCustomers(nameFilter: String) = customerRepository.findCustomer(nameFilter)
}