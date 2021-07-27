package com.example.SpringBootRESTAPIs.defaultFilter

import org.springframework.data.domain.Sort

class SimpleParams (
        var page:Int?=0,
        var max:Int?=10,
        var offset:Int?=0,
        var sort : Sort.Direction?= Sort.Direction.DESC,
        var orderBy:String?="id"
)