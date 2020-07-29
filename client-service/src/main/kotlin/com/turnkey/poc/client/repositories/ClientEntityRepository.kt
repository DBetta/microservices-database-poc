package com.turnkey.poc.client.repositories

import com.turnkey.poc.client.entities.ClientEntity
import org.springframework.data.jpa.repository.JpaRepository

/**
 *
 * @author Denis Gitonga
 */
interface ClientEntityRepository: JpaRepository<ClientEntity, String> {
}