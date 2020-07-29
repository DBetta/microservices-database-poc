package com.turnkey.poc.client.graphql.mutations

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Mutation
import com.turnkey.poc.client.dtos.CreateClientDto
import com.turnkey.poc.client.services.ClientService
import org.springframework.stereotype.Component

/**
 *
 * @author Denis Gitonga
 */
@Component
class ClientMutation(
        private val clientService: ClientService
) : Mutation {


    @GraphQLDescription(value = "Creates a new client")
    suspend fun createClient(createClientDto: CreateClientDto): String {
        return clientService.createClient(createClientDto = createClientDto)
    }
}