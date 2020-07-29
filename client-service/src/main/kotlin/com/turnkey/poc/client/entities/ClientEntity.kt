package com.turnkey.poc.client.entities

import com.github.pozo.KotlinBuilder
import java.util.*
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
@Table(name = "tqc_clients")
data class ClientEntity(
        @Id
        @Column(name = "clnt_code")
        val code: String?,

        @Column(name = "clnt_name")
        val name: String,

        @Column(name = "clnt_email_address")
        val emailAddress: String,

        @Column(name = "clnt_phone_number")
        val phoneNumber: String
)
