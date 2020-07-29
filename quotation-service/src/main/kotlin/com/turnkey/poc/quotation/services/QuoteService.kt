package com.turnkey.poc.quotation.services

import com.turnkey.poc.quotation.dtos.CreateQuoteDto
import com.turnkey.poc.quotation.dtos.QuoteDto

/**
 *
 * @author Denis Gitonga
 */
interface QuoteService {

    suspend fun createQuote(createQuoteDto: CreateQuoteDto): String

    suspend fun getQuotes(): List<QuoteDto>

    suspend fun getClientQuotes(clientCodes: List<String>): List<QuoteDto>

}