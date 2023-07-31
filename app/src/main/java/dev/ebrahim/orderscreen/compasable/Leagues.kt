package dev.ebrahim.orderscreen.compasable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SectionLeagues() {
    var selectedLeague by remember { mutableStateOf(0) }
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(30.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(leagues.size) { index ->
            val league = leagues[index]
            val isSelected = index == selectedLeague
            Text(
                text = league,
                color = if (isSelected) Color.Black else Color.Gray,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        selectedLeague = index
                    }
            )
        }
    }
}


val leagues = listOf(
    "All", "PremierLeague", "LaLiga", "Bundisleague", "EgyptianLeague"
)