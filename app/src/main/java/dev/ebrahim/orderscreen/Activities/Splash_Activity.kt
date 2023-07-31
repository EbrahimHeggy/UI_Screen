package dev.ebrahim.orderscreen.Activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import dev.ebrahim.orderscreen.R
import dev.ebrahim.orderscreen.ui.theme.OrderScreenTheme
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrderScreenTheme {
                Surface(color = Color.LightGray, modifier = Modifier.fillMaxSize()) {
                    SplashContent {
                        navigateToMainActivity()
                    }
                }
            }
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}

@Composable
fun SplashContent(onDelayFinish: () -> Unit) {
    val splashDurationMillis = 2000L
    LaunchedEffect(true) {
        delay(splashDurationMillis)
        onDelayFinish()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.whats), contentDescription = "splash")
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    OrderScreenTheme {
        Surface(color = Color.LightGray, modifier = Modifier.fillMaxSize()) {
            SplashContent {}
        }
    }
}
