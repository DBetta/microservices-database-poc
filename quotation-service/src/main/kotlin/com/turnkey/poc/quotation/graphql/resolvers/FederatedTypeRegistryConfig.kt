package com.turnkey.poc.quotation.graphql.resolvers

import com.expediagroup.graphql.federation.execution.FederatedTypeRegistry
import com.turnkey.poc.api.graphql.TqFederatedTypeResolver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 *
 * @author Denis Gitonga
 */
@Configuration
class FederatedTypeRegistryConfig {

    @Bean
    fun federatedTypeRegistry(
            federatedResolverTypes: List<TqFederatedTypeResolver<*>>
    ): FederatedTypeRegistry {

        val federatedTypeResolvers = mutableMapOf<String, TqFederatedTypeResolver<*>>()

        for (federatedResolverType in federatedResolverTypes) {
            federatedTypeResolvers[federatedResolverType.typeName()] = federatedResolverType
        }


        return FederatedTypeRegistry(federatedTypeResolvers)
    }


}