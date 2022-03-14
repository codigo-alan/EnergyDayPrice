package com.alanapps.energydayprice.logic

class EnergyDayPrices(val mapOfPrices: Map<String, HourRange>) {

    fun findByHour(hourKey: String): HourRange? {
        for (k in mapOfPrices.keys) {
            if (k == hourKey) return mapOfPrices[k]
        }
        return null
    }


    fun findExpensive(): HourRange? {
        var keyOfMax = ""
        var maxPrice = Double.MIN_VALUE
        for (k in mapOfPrices.keys) if (mapOfPrices[k]!!.price > maxPrice) {
            maxPrice = mapOfPrices[k]!!.price
            keyOfMax = k
        }
        return mapOfPrices[keyOfMax]
    }

    fun findCheapest(): HourRange? {
        var keyOfMin = ""
        var minPrice = Double.MAX_VALUE
        for (k in mapOfPrices.keys) if (mapOfPrices[k]!!.price < minPrice) {
            minPrice = mapOfPrices[k]!!.price
            keyOfMin = k
        }
        return mapOfPrices[keyOfMin]
    }

    //TODO (complete this function)
    /*fun allRanges(): List<HourRange> {
        val listOfRange = mutableListOf<HourRange>()
        for ()
    }*/


}
