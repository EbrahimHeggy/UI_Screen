package dev.ebrahim.orderscreen.compasable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@Composable
fun BottomBar() {
    var selectedItem by remember { mutableStateOf(0) }

    Card(
        backgroundColor = Color.DarkGray,
        shape = RoundedCornerShape(15.dp),
        elevation = 8.dp,
        modifier = Modifier.padding(10.dp)
    ) {
        BottomAppBar(
            backgroundColor = Color.Transparent,
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxSize()
            ) {
                BottomBarItem(
                    icon = Icons.Default.Home,
                    label = "Home",
                    selected = selectedItem == 0
                ) {
                    selectedItem = 0
                }

                BottomBarItem(
                    icon = Icons.Default.Person,
                    label = "Profile",
                    selected = selectedItem == 1
                ) {
                    selectedItem = 1
                }

                BottomBarItem(
                    icon = Icons.Default.ShoppingCart,
                    label = "Cart",
                    selected = selectedItem == 2
                ) {
                    selectedItem = 2
                }
            }
        }
    }
}

@Composable
fun BottomBarItem(icon: ImageVector, label: String, selected: Boolean, onItemClicked: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onItemClicked)
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(
                    color = if (selected) Color.Black else Color.Transparent,
                    shape = RoundedCornerShape(percent = 50)
                )
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = if (selected) Color.White else Color.Black
            )
        }
        Text(
            text = label,
            style = MaterialTheme.typography.caption.copy(
                color = if (selected) Color.Black else Color.Gray
            )
        )
    }
}

