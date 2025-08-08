package com.and.flightbooking.Activities.Splash

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.and.flightbooking.Activities.Dashboad.DashboardActivity
import com.and.flightbooking.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class SplashActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SplashScreen(onGetStartedClick = {
                startActivity(Intent(this, DashboardActivity::class.java))
                finish() // Close splash so it doesn't come back on back press
            })
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SplashScreen(onGetStartedClick: () -> Unit = {}) {
    StatusTopBarColor()
    Column(modifier = Modifier.fillMaxSize()) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {

            val (backgroundImg, title, subtitle, startbtn) = createRefs()

            // Background image
            Image(
                painter = painterResource(R.drawable.splash_bg),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .constrainAs(backgroundImg) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            )

            // Title text
            val styledText = buildAnnotatedString {
                append("Discover your\nDream")
                withStyle(style = SpanStyle(color = colorResource(R.color.orange))) {
                    append(" Flight")
                }
                append("\nEasily")
            }

            Text(
                text = styledText,
                fontSize = 53.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 32.dp)
                    .padding(horizontal = 16.dp)
                    .constrainAs(title) {
                        top.linkTo(parent.top, margin = 80.dp)
                        start.linkTo(parent.start)
                    }
            )

            // Subtitle text
            Text(
                text = stringResource(R.string.subtitle_splash),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(R.color.orange),
                modifier = Modifier
                    .padding(top = 8.dp, start = 16.dp)
                    .constrainAs(subtitle) {
                        top.linkTo(title.bottom)
                        start.linkTo(title.start)
                    }
            )

            // Start button
            Box(
                modifier = Modifier
                    .constrainAs(startbtn) {
                        bottom.linkTo(parent.bottom, margin = 48.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                GradientButton(
                    onClick = onGetStartedClick,
                    text = "Get Started",
                    padding = 32
                )
            }
        }
    }
}

@Composable
fun StatusTopBarColor() {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = false
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}
