package com.alanapps.energydayprice
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alanapps.energydayprice.client.GetFromClient
import com.alanapps.energydayprice.logic.EnergyDayPrices
import com.alanapps.energydayprice.logic.HourRange
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString




class MainActivity : AppCompatActivity() {
    val energyDayMap = getFromClient()
    val energyDayPrices = EnergyDayPrices(energyDayMap)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showCheapest()
        showExpensive()
    }

    private fun getFromClient(): HashMap<String,HourRange>{
        return runBlocking {
            GetFromClient().loadFromApi()
        }
    }

    fun showCheapest(){
        val hourRange = energyDayPrices.findCheapest()
        txt_price.text = hourRange!!.price.toString() + " ${hourRange!!.units}"
        txt_day.text = hourRange!!.date
        txt_hour.text = hourRange!!.hour
    }
    fun showExpensive(){
        val hourRange = energyDayPrices.findExpensive()
        txt_price_expensive.text = hourRange!!.price.toString() + " ${hourRange!!.units}"
        txt_day_expensive.text = hourRange!!.date
        txt_hour_expensive.text = hourRange!!.hour
    }

    fun completeDay(view: View){
        val listAllRanges = energyDayPrices.listOfRanges()
        val jsonList = Json.encodeToString(listAllRanges)

        val completeDay = Intent(this,AllRanges::class.java)
        completeDay.putExtra("keyOfList",jsonList)
        startActivity(completeDay)
    }
}