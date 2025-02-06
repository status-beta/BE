package com.status.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StatusApiApplication

fun main(args: Array<String>) {
    runApplication<StatusApiApplication>(*args)
}
