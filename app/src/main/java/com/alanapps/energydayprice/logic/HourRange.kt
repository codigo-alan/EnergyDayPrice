package com.alanapps.energydayprice.logic

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourRange (
    val date: String,
    val hour: String,
    @SerialName("is-cheap") val isCheap: Boolean,
    @SerialName("is-under-avg") val isUnderAvg: Boolean,
    val market: String,
    val price: Double,
    val units: String)
