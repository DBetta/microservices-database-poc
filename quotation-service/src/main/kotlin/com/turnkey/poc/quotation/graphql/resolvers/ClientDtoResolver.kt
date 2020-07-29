package com.turnkey.poc.quotation.graphql.resolvers

import com.turnkey.poc.api.graphql.TqFederatedTypeResolver
import com.turnkey.poc.quotation.dtos.ClientDto
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component

/**
 *
 * @author Denis Gitonga
 */
@Component
class ClientDtoResolver : TqFederatedTypeResolver<ClientDto> {
    override fun typeName(): String = "ClientDto"

    override suspend fun resolve(environment: DataFetchingEnvironment, representations: List<Map<String, Any>>): List<ClientDto?> {
        return representations.map { representation ->
            val clientCode = representation["code"]?.toString()
                    ?: throw RuntimeException("missing client code property")
            ClientDto(code = clientCode)
        }
    }
}