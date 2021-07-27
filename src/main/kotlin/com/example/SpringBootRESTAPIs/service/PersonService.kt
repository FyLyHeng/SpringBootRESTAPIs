package com.example.SpringBootRESTAPIs.service

import com.example.SpringBootRESTAPIs.Repository.PersonRepo
import com.example.SpringBootRESTAPIs.model.Person
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.*
import javax.persistence.criteria.Predicate


@Service
class PersonService(private val personRepo: PersonRepo) {

    fun listPerson(): MutableList<Person> {
        return personRepo.findAll()
    }

    fun getPerson(id:Long): Person {
        return personRepo.getById(id)
    }

    fun updatePerson(person: Person): Person {
        return personRepo.saveAndFlush(person)
    }

    fun deletePerson(id: Long){
        personRepo.deleteById(id)
    }

    fun savePerson(person: Person): Person {
        return personRepo.save(person)
    }

    fun findAllCriteria(name:String?,gender:String?, page:Int, size:Int): Page<Person>?{
        return personRepo.findAll({
                    root, _, cb ->
                    val predicate = ArrayList<Predicate>()
                    if (name != null){
                        val conditionName = cb.like( root.get("name"), "%${name}%")
                        predicate.add(conditionName)
                    }

                    if (gender != null){
                        val qGender = cb.equal(root.get<String>("gender"),gender)
                        predicate.add(qGender)
                    }

                    cb.and()

                }, PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"id")))
    }
}