package com.io.muhsin.rickandmorty.ui.radio_buttons


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.io.muhsin.rickandmorty.MainViewModel


@Composable
fun Buttons() {

    val viewModel = hiltViewModel<MainViewModel>()


    val radioOptions = listOf("Жив", "Мертв", "Неизвестно")
    val radioOptions2 = listOf("Человек", "Гуманоид", "Пришелец")
    val radioOptions3 = listOf("Мужской", "Женский", "Неизвестно")

    var selectedItem by remember {
        mutableStateOf(radioOptions[0])
    }
    var selectedItem2 by remember {
        mutableStateOf(radioOptions[0])
    }
    var selectedItem3 by remember {
        mutableStateOf(radioOptions[0])
    }

    Column(
        Modifier.padding(30.dp)
    ) {
        Card(Modifier.padding(4.dp), elevation = 4.dp) {
            Column(modifier = Modifier
                .selectableGroup()
                .padding(8.dp)) {
                Text(text = "Статус",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                radioOptions.forEach { label ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(36.dp)
                            .selectable(
                                selected = (selectedItem == label),
                                onClick = { selectedItem = label },
                                role = Role.RadioButton
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            modifier = Modifier.padding(end = 16.dp),
                            selected = (selectedItem == label),
                            onClick = null
                        )
                        Text(text = label)
                    }
                }
            }
        }
        Card(Modifier.padding(4.dp), elevation = 4.dp) {
            Column(modifier = Modifier
                .selectableGroup()
                .padding(8.dp)) {
                Text(text = "Раса",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp)
                radioOptions2.forEach { label ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(36.dp)
                            .selectable(
                                selected = (selectedItem2 == label),
                                onClick = { selectedItem2 = label },
                                role = Role.RadioButton
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            modifier = Modifier.padding(end = 16.dp),
                            selected = (selectedItem2 == label),
                            onClick = null
                        )
                        Text(text = label)
                    }
                }
            }
        }
        Card(Modifier.padding(4.dp), elevation = 4.dp) {

            Column(modifier = Modifier
                .selectableGroup()
                .padding(8.dp)) {
                Text(text = "Пол",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp)
                radioOptions3.forEach { label ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(36.dp)
                            .selectable(
                                selected = (selectedItem3 == label),
                                onClick = { selectedItem3 = label },
                                role = Role.RadioButton
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            modifier = Modifier.padding(end = 16.dp),
                            selected = (selectedItem3 == label),
                            onClick = null
                        )
                        Text(text = label)
                    }
                }
            }
        }
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {

            },
            modifier = Modifier
                .padding(bottom = 60.dp, start = 34.dp, end = 32.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow)
        ) {
            Text(text = "Применить", modifier = Modifier)

        }
    }
}