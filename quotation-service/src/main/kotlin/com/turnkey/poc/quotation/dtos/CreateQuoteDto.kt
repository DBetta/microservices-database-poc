package com.turnkey.poc.quotation.dtos

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.github.pozo.KotlinBuilder

/**
 *
 * @author Denis Gitonga
 */
@KotlinBuilder
@GraphQLDescription(value = "An object holding information to create a quote")
data class CreateQuoteDto(
        @GraphQLDescription(value = "The client to be associated with the quote")
        val clientCode: String,

        @GraphQLDescription(value = "The product for the quote")
        val product: String,

        @GraphQLDescription(value = "The agent associated with the quote")
        val agent: String
)
