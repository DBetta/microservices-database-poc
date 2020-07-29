package com.turnkey.poc.client.services

import com.turnkey.poc.client.dtos.ClientDto
import com.turnkey.poc.client.dtos.CreateClientDto
import com.turnkey.poc.client.mappers.ClientMapper
import com.turnkey.poc.client.repositories.ClientEntityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import java.util.*

/**
 *
 * @author Denis Gitonga
 */
@Service
internal class ClientServiceImpl(
        private val clientEntityRepository: ClientEntityRepository,
        private val clientMapper: ClientMapper
) : ClientService {
    override suspend fun createClient(createClientDto: CreateClientDto): String {
        val rawClientEntity = clientMapper.map(createClientDto = createClientDto)
                .copy(code = UUID.randomUUID().toString())

        val savedClientEntity = withContext(Dispatchers.IO) {
            clientEntityRepository.save(rawClientEntity)
        }


        return savedClientEntity.code!!
    }

    override suspend fun getClients(): List<ClientDto> = withContext(Dispatchers.IO) {
        clientEntityRepository.findAll()
    }.map { clientMapper.map(clientEntity = it) }


}