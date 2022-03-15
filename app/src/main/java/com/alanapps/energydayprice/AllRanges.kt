package com.alanapps.energydayprice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alanapps.energydayprice.logic.EnergyDayPrices
import kotlinx.android.synthetic.main.activity_all_ranges.*
import java.io.Serializable

class AllRanges : AppCompatActivity() {

    val bundle = intent.extras

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_ranges)
        val energyDayPrices = bundle!!.getSerializable("energyPrices")
        //showAllRanges(energyDayPrices)
        // TODO (ver como llamar si es serializable, quizás con decodeFromString
        //  y convertirlo en EnergyDayPrices)
    }

    fun showAllRanges(prices: EnergyDayPrices){
        val listOfRanges = prices.listOfRanges() //devuelve lista de rangos horarios
        for (range in listOfRanges) {
            //TODO (que agregue textView en layout por cada rango y su exto sea el siguiente)
            println(range.hour)
            println(range.price)
        }
    }
}