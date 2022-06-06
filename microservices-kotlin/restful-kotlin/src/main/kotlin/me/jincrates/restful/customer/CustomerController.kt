package me.jincrates.restful.customer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController {


    @GetMapping(value = arrayOf("/customer"))
    fun getCustomer() = Customer(1, "Kotlin");

}