package com.turnkey.poc.quotation.graphql.mutations

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Mutation
import com.turnkey.poc.quotation.dtos.CreateQuoteDto
import com.turnkey.poc.quotation.services.QuoteService
import org.springframework.stereotype.Component

/**
 *
 * @author Denis Gitonga
 */
@Component
class QuoteMutation(
        private val quoteService: QuoteService
) : Mutation {


    @GraphQLDescription("creates a new quote.")
    suspend fun createQuote(createQuoteDto: CreateQuoteDto): String {
        return quoteService.createQuote(createQuoteDto = createQuoteDto)
    }
}