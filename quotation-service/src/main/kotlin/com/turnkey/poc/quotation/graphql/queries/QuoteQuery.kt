package com.turnkey.poc.quotation.graphql.queries


import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Query
import com.turnkey.poc.quotation.dtos.QuoteDto
import com.turnkey.poc.quotation.services.QuoteService
import org.springframework.stereotype.Component

/**
 *
 * @author Denis Gitonga
 */
@Component
class QuoteQuery(
        private val quoteService: QuoteService
) : Query {

    @GraphQLDescription("Get's all quotes")
    suspend fun getQuotes(): List<QuoteDto> {
        return quoteService.getQuotes()
    }
}