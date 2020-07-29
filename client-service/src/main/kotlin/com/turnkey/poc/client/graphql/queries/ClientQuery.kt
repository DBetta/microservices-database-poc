package com.turnkey.poc.client.graphql.queries

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Query
import com.turnkey.poc.client.dtos.ClientDto
import com.turnkey.poc.client.services.ClientService
import org.springframework.stereotype.Component

/**
 *
 * @author Denis Gitonga
 */
@Component
class ClientQuery(
        private val clientService: ClientService
) : Query {

    @GraphQLDescription("Gets the list of clients")
    suspend fun getClients(): List<ClientDto> {
        return clientService.getClients()
    }
}