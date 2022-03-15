package com.alanapps.energydayprice.client

import com.alanapps.energydayprice.logic.HourRange
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.serialization.Serializable


class GetFromClient {
    suspend fun loadFromApi(): HashMap<String, HourRange> {
        val client = HttpClient(CIO){
            install(JsonFeature){
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json { ignoreUnknownKeys = true })
            }
        }
        val energyDayMap : HashMap<String,HourRange> = client.get("https://api.preciodelaluz.org/v1/prices/all?zone=PCB"
            )
        return energyDayMap
    }
}