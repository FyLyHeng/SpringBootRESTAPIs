package com.example.SpringBootRESTAPIs.controller

import com.example.SpringBootRESTAPIs.model.Person
import com.example.SpringBootRESTAPIs.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.sql.DriverManager

@RestController
@RequestMapping("/person")
class PersonController {
    @Autowired
    lateinit var personService: PersonService


    @GetMapping
    fun index(): MutableList<Person> {
        DriverManager.println("print mee here list all bro!")

        return personService.listPerson()
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): Person {
        DriverManager.println("print mee here get bro!")

        return personService.getPerson(id)
    }

    @PutMapping
    fun edit(@RequestBody person: Person): Person {
        DriverManager.println("print mee here edit bro!")

        return personService.updatePerson(person)
    }

    @PostMapping
    fun save(@RequestBody person: Person): Person {
        DriverManager.println("print mee here save bro!")
        return  personService.savePerson(person)
    }

    @DeleteMapping
    fun delete(@RequestParam id: Long) : String {
        DriverManager.println("print mee here delete bro!")
        personService.deletePerson(id)
        return "Account ID $id delete success."
    }
}