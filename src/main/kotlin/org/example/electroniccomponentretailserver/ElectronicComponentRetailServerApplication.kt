package org.example.electroniccomponentretailserver

import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class ElectronicComponentRetailServerApplication

fun main(args: Array<String>) {
    runApplication<ElectronicComponentRetailServerApplication>(*args)
}

@Component
class ServerInfoLogger {
    @Value("\${server.port}")
    private lateinit var port: String

    @Value("\${server.address}")
    private lateinit var address: String

    @PostConstruct
    fun logServerInfo() {
        println("Application is running on address: $address and port: $port")
    }
}

