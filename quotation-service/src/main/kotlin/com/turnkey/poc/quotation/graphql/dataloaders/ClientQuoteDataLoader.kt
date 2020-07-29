package com.turnkey.poc.quotation.graphql.dataloaders

import com.turnkey.poc.quotation.dtos.QuoteDto
import com.turnkey.poc.quotation.services.QuoteService
import kotlinx.coroutines.reactor.mono
import org.dataloader.BatchLoader
import org.dataloader.DataLoader
import org.springframework.stereotype.Component

/**
 *
 * @author Denis Gitonga
 */
@Component
class ClientQuoteDataLoader(
        private val quoteService: QuoteService
) : DataLoader<String, List<QuoteDto>>(BatchLoader { clientCodes ->

    mono {
        val quotes = quoteService.getClientQuotes(clientCodes = clientCodes)

        return@mono clientCodes.map { code -> quotes.filter { it.clientCode == code } }
    }.toFuture()

    /*mono { quoteService.getClientQuotes(clientCodes = clientCodes) }
            .toFuture()*/
})