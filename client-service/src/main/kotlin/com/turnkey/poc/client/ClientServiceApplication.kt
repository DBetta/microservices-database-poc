package com.turnkey.poc.client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 *
 * @author Denis Gitonga
 */
@SpringBootApplication
class ClientServiceApplication

fun main(args: Array<String>) {
    runApplication<ClientServiceApplication>(*args)
}