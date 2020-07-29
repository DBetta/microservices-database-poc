package com.turnkey.poc.client.mappers

import com.turnkey.poc.client.dtos.ClientDto
import com.turnkey.poc.client.dtos.CreateClientDto
import com.turnkey.poc.client.entities.ClientEntity
import org.mapstruct.Mapper

/**
 *
 * @author Denis Gitonga
 */
@Mapper(componentModel = "spring")
interface ClientMapper {

    fun map(createClientDto: CreateClientDto): ClientEntity

    fun map(clientEntity: ClientEntity): ClientDto

}