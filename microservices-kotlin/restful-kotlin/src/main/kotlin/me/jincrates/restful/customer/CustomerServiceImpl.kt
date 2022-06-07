package me.jincrates.restful.customer

import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class CustomerServiceImpl : CustomerService {
    companion object {
        private val initialCustomers = arrayOf(
            Customer(1, "Kotlin"),
            Customer(2, "Spring", Customer.Telephone("+84", "43218765")),
            Customer(3, "Microservice", Customer.Telephone("+83", "12345678")))
    }
    val customers = ConcurrentHashMap<Int, Customer>(initialCustomers.associateBy(Customer::id))

    override fun getCustomer(id: Int) = customers[id];

    override fun createCustomer(customer: Customer) {
        customers[customer.id] = customer;
    }

    override fun deleteCustomer(id: Int) {
        customers.remove(id);
    }

    override fun updateCustomer(id: Int, customer: Customer) {
        deleteCustomer(id)
        createCustomer(customer)
    }

    override fun searchCustomers(nameFilter: String): List<Customer> =
        customers.filter {
            it.value.name.contains(nameFilter, true)
        }.map(Map.Entry<Int, Customer>::value).toList();
}