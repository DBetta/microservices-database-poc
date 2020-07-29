package com.turnkey.poc.quotation.graphql.dataloaders

import com.expediagroup.graphql.spring.execution.DataLoaderRegistryFactory
import org.dataloader.DataLoader
import org.dataloader.DataLoaderRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataLoaderConfig {

    @Bean
    fun dataLoaderRegistryFactory(dataLoaders: List<DataLoader<*, *>>): DataLoaderRegistryFactory {
        return object : DataLoaderRegistryFactory {
            override fun generate(): DataLoaderRegistry {
                val dataLoaderRegistry = DataLoaderRegistry()

                for (dataLoader in dataLoaders) {

                    dataLoaderRegistry.register(dataLoader.javaClass.simpleName, dataLoader)
                }

                return dataLoaderRegistry
            }

        }
    }
}