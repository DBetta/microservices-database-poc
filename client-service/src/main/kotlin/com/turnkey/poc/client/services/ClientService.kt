package com.turnkey.poc.client.services

import com.turnkey.poc.client.dtos.ClientDto
import com.turnkey.poc.client.dtos.CreateClientDto

/**
 *
 * @author Denis Gitonga
 */
interface ClientService {

    suspend fun createClient(createClientDto: CreateClientDto): String

    suspend fun getClients(): List<ClientDto>

}