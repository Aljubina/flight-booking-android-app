package com.and.flightbooking.Activities.SeatSelect

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.and.flightbooking.Activities.SearchResult.ItemListScreen
import com.and.flightbooking.Activities.Splash.StatusTopBarColor
import com.and.flightbooking.Domain.FlightModel
import com.and.flightbooking.R

class SeatSelectActivity : AppCompatActivity() {
    private lateinit var flight: FlightModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        flight=intent.getSerializableExtra("flight") as FlightModel

        setContent {
            StatusTopBarColor()
            SeatListScreen(
                flight = flight,
                onBackClick = {
                    finish()
                }, onConfirm = {

                }
            )
        }

    }
}