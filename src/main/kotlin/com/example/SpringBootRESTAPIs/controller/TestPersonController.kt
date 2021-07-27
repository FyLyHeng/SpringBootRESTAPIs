package com.example.SpringBootRESTAPIs.controller

import com.example.SpringBootRESTAPIs.model.Person
import com.example.SpringBootRESTAPIs.service.PersonService
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.sql.DriverManager.println

@RestController
@RequestMapping("/test")
class TestPersonController(private val personService: PersonService) {

    @GetMapping
    fun get(@RequestParam name:String,
            @RequestParam gender:String,
            @RequestParam(defaultValue = "1") page:Int,
            @RequestParam(defaultValue = "10") size:Int
    ): Page<Person>? {
        println("sorry am here not work yet")
        return personService.findAllCriteria(name,gender,page,size)
    }
}