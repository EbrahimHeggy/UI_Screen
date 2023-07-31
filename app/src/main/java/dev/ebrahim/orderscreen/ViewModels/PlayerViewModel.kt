package dev.ebrahim.orderscreen.ViewModels

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dev.ebrahim.orderscreen.compasable.Player
import dev.ebrahim.orderscreen.compasable.Players

//class PlayerViewModel : ViewModel() {
//
//    var isFavorite by mutableStateOf(false)
//
//    fun changeFavorite() {
//        isFavorite = isFavorite.not()
//    }
//}



class PlayerViewModel : ViewModel() {
    private val players = mutableStateListOf<Player>()

    val listPlayers = players

    init {
        players.addAll(Players)
    }

    fun changeFavorite(playerId: Int) {
//        players.find { it.id == playerId }?.isFavorite = players.find { it.id == playerId }?.isFavorite?.not() ?: false
      players[playerId]= players[playerId].copy(isFavorite = !players[playerId].isFavorite)

    }
}
