package com.turnkey.poc.quotation.dtos

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.federation.directives.ExtendsDirective
import com.expediagroup.graphql.federation.directives.ExternalDirective
import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective
import com.turnkey.poc.quotation.graphql.dataloaders.ClientQuoteDataLoader
import graphql.schema.DataFetchingEnvironment
import kotlinx.coroutines.reactive.awaitFirstOrDefault
import reactor.core.publisher.Mono

/**
 *
 * @author Denis Gitonga
 */
@ExtendsDirective
@KeyDirective(fields = FieldSet("code"))
data class ClientDto(
        @ExternalDirective val code: String
) {

    @GraphQLDescription("Get's list of quotes for the current client")
    suspend fun getQuotes(environment: DataFetchingEnvironment): List<QuoteDto> {
        return Mono.fromCompletionStage {
            environment.getDataLoader<String, List<QuoteDto>>(ClientQuoteDataLoader::class.java.simpleName)
                    .load(code)
        }.awaitFirstOrDefault(emptyList())
    }
}