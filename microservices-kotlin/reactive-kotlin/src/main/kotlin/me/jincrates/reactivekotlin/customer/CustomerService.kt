package me.jincrates.reactivekotlin.customer

interface CustomerService {
    fun getCustomer(id: Int) : Customer?
    fun searchCustomers(nameFilter: String) : List<Customer>
}