package com.turnkey.poc.quotation.services

import com.turnkey.poc.quotation.dtos.CreateQuoteDto
import com.turnkey.poc.quotation.dtos.QuoteDto
import com.turnkey.poc.quotation.mappers.QuoteMapper
import com.turnkey.poc.quotation.repositories.QuoteEntityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import java.util.*

/**
 *
 * @author Denis Gitonga
 */
@Service
class QuoteServiceImpl(
        private val quoteEntityRepository: QuoteEntityRepository,
        private val quoteMapper: QuoteMapper
) : QuoteService {
    override suspend fun createQuote(createQuoteDto: CreateQuoteDto): String {

        val rawQuoteEntity = quoteMapper.map(createQuoteDto = createQuoteDto)
                .copy(code = UUID.randomUUID().toString(), status = "CREATED")

        val savedQuoteEntity = withContext(Dispatchers.IO) {
            quoteEntityRepository.save(rawQuoteEntity)
        }

        return savedQuoteEntity.code!!
    }

    override suspend fun getQuotes(): List<QuoteDto> = withContext(Dispatchers.IO) {
        quoteEntityRepository.findAll()
    }.map { quoteMapper.map(quoteEntity = it) }

    override suspend fun getClientQuotes(clientCodes: List<String>): List<QuoteDto> {

        if (clientCodes.isEmpty())
            return emptyList()

        return withContext(Dispatchers.IO) {
            quoteEntityRepository.getClientQuotes(clientCodes = clientCodes)
        }.map { quoteMapper.map(it) }
    }
}