package com.turnkey.poc.quotation.repositories

import com.turnkey.poc.quotation.entities.QuoteEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

/**
 *
 * @author Denis Gitonga
 */
interface QuoteEntityRepository: JpaRepository<QuoteEntity, String> {

    @Query(value = """
        SELECT q FROM QuoteEntity q
        WHERE q.clientCode in (?1)
    """)
    fun getClientQuotes(clientCodes: List<String>): List<QuoteEntity>
}