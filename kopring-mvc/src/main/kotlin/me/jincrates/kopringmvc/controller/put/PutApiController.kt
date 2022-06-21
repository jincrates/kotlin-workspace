package me.jincrates.kopringmvc.controller.put

import me.jincrates.kopringmvc.model.http.Result
import me.jincrates.kopringmvc.model.http.UserRequest
import me.jincrates.kopringmvc.model.http.UserResponse
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    @PutMapping(path = ["/put-mapping/object"])
    fun putMappingObject(@RequestBody userRequest: UserRequest): UserResponse {
        // 1. Response
        return UserResponse().apply {
            // 2. result
            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {
            // 3. description
            this.description = "~~~~~~~~~~"

        }.apply {
            // 4. user mutable list
            val userList = mutableListOf<UserRequest>()
            userList.add(userRequest)
            userList.add(UserRequest().apply {
                this.name = "platon"
                this.age = 20
                this.email = "platon@email.com"
                this.address = "platon address"
                this.phoneNumber = "010-1111-2222"
            })
            userList.add(UserRequest().apply {
                this.name = "kant"
                this.age = 30
                this.email = "kant@email.com"
                this.address = "kant address"
                this.phoneNumber = "010-3333-4444"
            })

            this.userRequest = userList
        }
    }
}