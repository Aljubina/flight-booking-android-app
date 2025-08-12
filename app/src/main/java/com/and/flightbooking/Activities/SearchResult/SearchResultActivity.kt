package com.and.flightbooking.Activities.SearchResult

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.and.flightbooking.Activities.Splash.StatusTopBarColor
import com.and.flightbooking.ViewModel.MainViewModel

class SearchResultActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private var from:String=""
    private var to:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        from=intent.getStringExtra("from")?:""
        to=intent.getStringExtra("to")?:""

        setContent {
            StatusTopBarColor()

            ItemListScreen(
                from = from,
                to = to,
                viewModel = viewModel,
                onBackClick={finish()}
            )
        }
    }

//    private fun ItemListScreen(
//        from:String,
//        to: String,
//        viewModel: MainViewModel,
//        onBackClick: () -> Unit
//    ) {
//
//    }
}