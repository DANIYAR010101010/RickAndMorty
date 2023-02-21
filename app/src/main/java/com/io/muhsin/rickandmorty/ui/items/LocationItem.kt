package com.io.muhsin.rickandmorty.ui.characterItem

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.io.muhsin.rickandmorty.models.location.ResultX
import com.io.muhsin.rickandmorty.MainViewModel

@Composable
fun LocationItem(item: ResultX, navController: NavController.Companion,viewModel: MainViewModel) {
    Card(elevation = 4.dp,
        modifier = Modifier
            .padding(top = 8.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 24.dp)
        ) {
            Text(
                text = item.name.toString(),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
            Row(modifier = Modifier.padding(start = 12.dp)
            ) {
                Text(text = "type: ",Modifier.padding(top = 4.dp))
                Text(
                    text = item.type.toString(),
                    fontSize = 18.sp,
                    modifier =  Modifier.padding(top = 2.dp)
                )
            }

            Row(modifier = Modifier.padding(start = 12.dp)
            ) {
                Text(text = "dimension: ",Modifier.padding(top = 4.dp))
                Text(
                    text = item.dimension.toString(),
                    fontSize = 18.sp,
                    modifier =  Modifier.padding(top = 2.dp))
            }
        }
    }
}