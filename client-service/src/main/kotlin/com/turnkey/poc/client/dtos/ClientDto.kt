package com.turnkey.poc.client.dtos

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.github.pozo.KotlinBuilder

/**
 *
 * @author Denis Gitonga
 */
@KotlinBuilder
@GraphQLDescription("Holds the created client")
data class ClientDto(
        @GraphQLDescription(value = "The client generated code")
        val code: String,

        @GraphQLDescription(value = "The name of the client")
        val name: String,

        @GraphQLDescription(value = "THe email address of the client")
        val emailAddress: String,

        @GraphQLDescription(value = "The phone number of the client")
        val phoneNumber: String
)
