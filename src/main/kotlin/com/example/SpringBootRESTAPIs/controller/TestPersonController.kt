package com.example.SpringBootRESTAPIs.controller

import com.example.SpringBootRESTAPIs.defaultFilter.SimpleParams
import com.example.SpringBootRESTAPIs.model.Person
import com.example.SpringBootRESTAPIs.service.PersonService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Sort
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestPersonController(private val personService: PersonService) {

    @GetMapping
    fun get(@RequestParam name:String?,
            @RequestParam gender:String?,
            @RequestParam(defaultValue = "0") page:Int,
            @RequestParam(defaultValue = "10") size:Int,
            @RequestParam(defaultValue = "DESC") sort: Sort.Direction
    ): Page<Person>? {
        return personService.findAllCriteria(name,gender,"id", sort,page,size)
    }


    @GetMapping("/bind")
    fun testBindParamsWithObj(
            @RequestParam name: String?,
            @RequestParam gender: String?,
            @Validated params: SimpleParams
    ): Page<Person>? {
        return personService.findAllCriteria(name,gender,"id", params.sort!!,params.page!!,params.max!!)
    }
}