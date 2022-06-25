package me.jincrates.kopringmvc.example.controller.put

import me.jincrates.kopringmvc.example.model.http.Result
import me.jincrates.kopringmvc.example.model.http.UserRequest
import me.jincrates.kopringmvc.example.model.http.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

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
    fun putMappingObject(@Valid @RequestBody userRequest: UserRequest, bindingRequest: BindingResult): ResponseEntity<String> {

        //valid error message 출력하기
        if (bindingRequest.hasErrors()) {
            val messages = StringBuilder()
            bindingRequest.allErrors.forEach {
                val field = it as FieldError
                val message = it.defaultMessage
                messages.append("${field.field} : $message\n")
            }
            return ResponseEntity.badRequest().body(messages.toString())
        }

        return ResponseEntity.ok("");
        /*
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

            this.user = userList
        }
        */
    }
}