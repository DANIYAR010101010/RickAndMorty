package com.io.muhsin.rickandmorty.ui.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.io.muhsin.rickandmorty.models.character.Result

@Composable
fun CharacterItem(item: Result, navController: NavController.Companion) {
    Card(elevation = 4.dp,
        modifier = Modifier
            .padding(top = 8.dp)
            .clickable {}
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
            Image(
                painter = rememberImagePainter(item.image),
                contentDescription = null,
                Modifier.size(128.dp)
            )
            Column {
                Text(
                    text = item.name.toString(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 12.dp)
                )
                Row(modifier = Modifier.padding(start = 12.dp))
                {
                    Text(text = "species: ",Modifier.padding(top = 4.dp))
                    Text(
                        text = item.species.toString(),
                        fontSize = 20.sp,
                    )
                }
                Row(modifier = Modifier.padding(start = 12.dp))
                {
                    Text(text = "status: ",Modifier.padding(top = 4.dp))
                    Text(
                        text = item.status.toString(),
                        fontSize = 20.sp,
                    )
                }
                Row(modifier = Modifier.padding(start = 12.dp))
                {
                    Text(text = "gender: ",Modifier.padding(top = 4.dp))
                    Text(
                        text = item.gender.toString(),
                        fontSize = 20.sp,
                    )
                }
            }
        }
    }

}