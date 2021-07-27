package com.example.SpringBootRESTAPIs.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.*
import javax.swing.text.DateFormatter

@Entity
data class Person(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id:Long?=-1,

        @Column(length = 50)
        var name:String?="",

        @Column(length = 50)
        var email:String?="",

        @Column(length = 50)
        var gender:String?="",

        @Column(nullable = true)
        var address:String?="",

        @Column(nullable = true)
        @Temporal(TemporalType.TIMESTAMP)
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
        var dateOfBirth:Date?=null
)
