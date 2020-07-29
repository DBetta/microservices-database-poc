package com.turnkey.poc.quotation.entities

import com.github.pozo.KotlinBuilder
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 *
 * @author Denis Gitonga
 */
@Entity
@KotlinBuilder
@Table(name = "gin_quotes")
data class QuoteEntity(
        @Id
        @Column(name = "quot_code")
        val code: String?,

        @Column(name = "quot_clnt_code")
        val clientCode: String,

        @Column(name = "quot_product")
        val product: String,

        @Column(name = "quot_agent")
        val agent: String,

        @Column(name = "quot_status")
        val status: String?
)
