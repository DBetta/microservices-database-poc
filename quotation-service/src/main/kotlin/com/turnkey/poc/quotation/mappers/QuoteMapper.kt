package com.turnkey.poc.quotation.mappers

import com.turnkey.poc.quotation.dtos.CreateQuoteDto
import com.turnkey.poc.quotation.dtos.QuoteDto
import com.turnkey.poc.quotation.entities.QuoteEntity
import org.mapstruct.Mapper

/**
 *
 * @author Denis Gitonga
 */
@Mapper(componentModel = "spring")
interface QuoteMapper {

    fun map(createQuoteDto: CreateQuoteDto): QuoteEntity

    fun map(quoteEntity: QuoteEntity): QuoteDto

}