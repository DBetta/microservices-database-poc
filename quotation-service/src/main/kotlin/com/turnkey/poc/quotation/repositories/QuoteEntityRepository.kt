package com.turnkey.poc.quotation.repositories

import com.turnkey.poc.quotation.entities.QuoteEntity
import org.springframework.data.jpa.repository.JpaRepository

/**
 *
 * @author Denis Gitonga
 */
interface QuoteEntityRepository: JpaRepository<QuoteEntity, String> {
}