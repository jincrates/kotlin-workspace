package me.jincrates.restful.customer

import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class CustomerServiceImpl : CustomerService {
    companion object {
        private val initialCustomers = arrayOf(
            Customer(1, "Kotlin"),
            Customer(2, "Spring"),
            Customer(3, "Microservice"))
        val customers = ConcurrentHashMap<Int, Customer>(initialCustomers.associateBy(Customer::id))
    }

    //service 구현하기

    override fun getCustomer(id: Int): Customer? {
        TODO("Not yet implemented")
    }

    override fun createCustomer(customer: Customer) {
        TODO("Not yet implemented")
    }

    override fun deleteCustomer(id: Int) {
        TODO("Not yet implemented")
    }

    override fun updateCustomer(id: Int, customer: Customer) {
        TODO("Not yet implemented")
    }

    override fun searchCustomers(nameFilter: String): List<Customer> {
        TODO("Not yet implemented")
    }
}