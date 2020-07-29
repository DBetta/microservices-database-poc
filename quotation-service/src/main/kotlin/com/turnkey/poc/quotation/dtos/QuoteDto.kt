package com.turnkey.poc.quotation.dtos

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.github.pozo.KotlinBuilder

/**
 *
 * @author Denis Gitonga
 */
@KotlinBuilder
data class QuoteDto(
        @GraphQLDescription(value = "The reference to the quote")
        val code: String,

        @GraphQLDescription(value = "The client to be associated with the quote")
        val clientCode: String,

        @GraphQLDescription(value = "The product for the quote")
        val product: String,

        @GraphQLDescription(value = "The agent associated with the quote")
        val agent: String,

        @GraphQLDescription(value = "The current status of the quote")
        val status: String
)