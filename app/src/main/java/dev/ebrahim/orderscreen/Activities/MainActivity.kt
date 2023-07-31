package dev.ebrahim.orderscreen.Activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.ebrahim.orderscreen.ViewModels.PlayerViewModel
import dev.ebrahim.orderscreen.compasable.BarSection
import dev.ebrahim.orderscreen.compasable.BottomBar
import dev.ebrahim.orderscreen.compasable.PlayersList
import dev.ebrahim.orderscreen.compasable.SearchSection
import dev.ebrahim.orderscreen.compasable.SectionLeagues
import dev.ebrahim.orderscreen.compasable.greet
import dev.ebrahim.orderscreen.ui.theme.OrderScreenTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel :PlayerViewModel by viewModels ()
        setContent {
            OrderScreenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Color.LightGray
                ) {
                    Column {
                        BarSection()
                        Spacer(height = 10)
                        greet()
                        Spacer(height = 10)
                        SearchSection()
                        Spacer(height = 30)
                        SectionLeagues()
                        Spacer(height = 30)
                        PlayersList(players = viewModel.listPlayers) { playerId ->
                            viewModel.changeFavorite(playerId)
                        }
                        Spacer(height = 50)
                        BottomBar()
//                        ProfileList()
                    }
                }
            }
        }
    }
}

@Composable
fun Spacer(height: Int) {
    Spacer(modifier = Modifier.height(height.dp))
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    BarSection()
//    greet()
//    SearchSection()
//    SectionLeagues()
//    PlayersList()
//    BottomBar()
}

