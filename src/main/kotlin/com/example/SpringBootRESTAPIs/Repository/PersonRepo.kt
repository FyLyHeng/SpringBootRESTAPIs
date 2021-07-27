package com.example.SpringBootRESTAPIs.Repository

import com.example.SpringBootRESTAPIs.model.Person
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface PersonRepo:JpaRepository<Person,Long> , JpaSpecificationExecutor<Person>{

}