package com.io.muhsin.rickandmorty.ui.items

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun EpisodeItem(item: com.io.muhsin.rickandmorty.models.episode.ResultZ, navController: NavController.Companion) {
    Card(elevation = 4.dp,
        modifier = Modifier
            .padding(top = 8.dp)

    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
                Text(
                    text =item.id.toString(),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text =item.name.toString(),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp),
                )
        }
    }

}