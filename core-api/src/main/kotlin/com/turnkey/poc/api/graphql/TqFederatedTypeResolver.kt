package com.turnkey.poc.api.graphql

import com.expediagroup.graphql.federation.execution.FederatedTypeResolver

/**
 *
 * @author Denis Gitonga
 */
interface TqFederatedTypeResolver<T> : FederatedTypeResolver<T> {

    /**
     * The entity type name
     */
    fun typeName(): String
}