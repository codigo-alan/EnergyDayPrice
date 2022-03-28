package com.alanapps.energydayprice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alanapps.energydayprice.logic.HourRange
import kotlinx.android.synthetic.main.activity_all_ranges.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString

class AllRanges : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_ranges)
        val bundle = intent.extras
        val jsonList = bundle!!.getString("keyOfList")
        val listOfRanges = Json.decodeFromString<List<HourRange>>(jsonList!!)
        val stringListOfRanges = showAllRanges(listOfRanges)
        txt_listRanges.text = stringListOfRanges
    }

    fun showAllRanges(listOfRanges: List<HourRange>): String{
        var stringDataRanges = ""
        for (range in listOfRanges) {
            stringDataRanges += "${range.hour}:   ${range.price} ${range.units} \n\n"
        }
        return stringDataRanges
    }
}