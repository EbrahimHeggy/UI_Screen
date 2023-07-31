package dev.ebrahim.orderscreen.compasable


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ebrahim.orderscreen.R
import dev.ebrahim.orderscreen.Activities.Spacer
import dev.ebrahim.orderscreen.ViewModels.PlayerViewModel
import dev.ebrahim.orderscreen.ui.theme.colorGray
import dev.ebrahim.orderscreen.ui.theme.heartColor

data class Player(
    val id: Int =0,
    val name: String="",
    val team: String="",
    val image: Int=0,
    var isFavorite: Boolean = false
)

val Players: List<Player> = listOf(
    Player(1, "Cristiano Ronaldo", "Plays in ALNasr", R.drawable.cr7),
    Player(2, "Lionel Messi", "Plays in Miami", R.drawable.messi),
    Player(3, "Mo Salah", "Plays in Liverpool", R.drawable.salah),
    Player(4, "Toni Kroos", "Plays in Real Madrid", R.drawable.kroos),
)


//@Composable
//fun PlayersList(players: List<Player>) {
//    val player = remember { PlayerViewModel() }
//    LazyRow(
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        items(players) { item: Player ->
//            playerCard(item, player.isFavorite) {
//                player.changeFavorite()
//            }
//        }
//    }
//}


@Composable
fun PlayersList(players: List<Player>, onIconClick: (Int) -> Unit) {
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        itemsIndexed(players) { index :Int , item :Player, ->
            playerCard(item, item.isFavorite) {
               onIconClick(index)
            }
        }
    }
}

@Composable
fun playerCard(player: Player, favorite: Boolean, onFavoriteClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .shadow(10.dp, RoundedCornerShape(30.dp), true),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_heart),
                contentDescription = "heart",
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable { onFavoriteClick() },
                tint = if (favorite) {
                    heartColor
                } else {
                    colorGray
                }
            )
            Image(
                painter = painterResource(id = player.image),
                contentDescription = "player${player.id}",
                modifier = Modifier
                    .width(142.dp)
                    .height(142.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(height = 10)
            Text(text = player.name, style = MaterialTheme.typography.subtitle2)
            Spacer(height = 10)
            Text(
                text = player.team,
                style = MaterialTheme.typography.body1.copy(fontSize = 10.sp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                modifier = Modifier.width(142.dp)
            )
            Spacer(height = 10)
        }
    }
}


