package com.turnkey.poc.quotation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 *
 * @author Denis Gitonga
 */
@SpringBootApplication
class QuotationServiceApplication

fun main(args: Array<String>) {
    runApplication<QuotationServiceApplication>(*args)
}