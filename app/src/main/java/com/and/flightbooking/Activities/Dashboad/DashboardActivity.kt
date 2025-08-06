package com.and.flightbooking.Activities.Dashboad

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.and.flightbooking.Activities.Domain.LocationModel
import com.and.flightbooking.Activities.Splash.StatusTopBarColor
import com.and.flightbooking.R
import com.and.flightbooking.ViewModel.MainViewModel

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
@Preview
fun MainScreen() {

    val locations = remember { mutableStateListOf<LocationModel>() }
    val viewModel = MainViewModel()
    var showLocationLoading by remember { mutableStateOf(true) }
    var from: String=""
    var to:String=""
    var classes:String=""

    StatusTopBarColor()

    LaunchedEffect(Unit) {
        viewModel.loadLocation().observeForever {result->
            locations.clear()
            locations.addAll(result)
            showLocationLoading=false
        }
    }
    Scaffold(
        bottomBar = { MyBottomBar() },

    ) {
        paddingValues ->
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.darkPurple2))
            .padding(paddingValues = paddingValues)
        ) {
            item{
                TopBar()
            }
            item {
                Column(
                    modifier = Modifier
                        .padding(32.dp)
                        .background(colorResource(R.color.darkPurple)
                        , shape = RoundedCornerShape(20.dp)
                        )
                        .fillMaxWidth()
                        .padding(vertical = 16.dp, horizontal = 24.dp)
                ) {
                    YellowTitle("From")
                    val locationNames: List<String> = locations.map{it.Name}

                    DropDownList(
                        items=locationNames,
                        loadingIcon = painterResource(R.drawable.from_ic),
                        hint = "Select origin",
                        showLocationLoading = showLocationLoading
                    ) {
                        selectedItem->
                        from=selectedItem
                    }
                }
            }
        }
    }
}

@Composable
fun YellowTitle(text:String, modifier: Modifier= Modifier) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        color = colorResource(R.color.orange),
        modifier = modifier
    )
}