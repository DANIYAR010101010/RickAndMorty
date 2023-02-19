package com.io.muhsin.rickandmorty.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.pager.*
import com.io.muhsin.rickandmorty.R
import com.io.muhsin.rickandmorty.ui.navigation.Screens
import com.io.muhsin.rickandmorty.ui.tablayout.TabItem
import kotlinx.coroutines.launch


@Composable
fun MainScreen(navController: NavController) {

    val viewModel = hiltViewModel<MainViewModel>()

    Column {
        Row(modifier = Modifier
            .padding(vertical = 12.dp, horizontal = 20.dp)
            .fillMaxWidth()
        )
        {
            var value by remember { mutableStateOf("") }
            TextField(value = value,
                onValueChange = { newText ->
                    value = newText
                    viewModel.searchCharacters(newText)
                },
                singleLine = true
                ,
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.Gray,
                    cursorColor = Color.Gray
                ),
                shape = RoundedCornerShape(12.dp),
                placeholder = { Text(text = "Поиск") },
                leadingIcon = {
                    Icon(imageVector = Icons.Rounded.Search,
                        contentDescription = "", modifier = Modifier.padding(bottom = 4.dp))
                }
            )
            Image(
                painter = painterResource(id = R.drawable.ic_filter_24),
                modifier = Modifier
                    .padding(start = 20.dp, top = 8.dp)
                    .size(36.dp)
                    .clickable {
                        navController.navigate(Screens.FilterScreen.route)
                    },
                contentDescription = "",
            )
        }
        mainContent()
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun mainContent() {
    val list = listOf(TabItem.Persons, TabItem.Locations, TabItem.Episodes)
    val pagerState = rememberPagerState()
    Column(Modifier.fillMaxSize()) {

        Tabs(list, pagerState = pagerState)
        tabContent(tabs = list, pagerState = pagerState)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun tabContent(tabs: List<TabItem>, pagerState: PagerState) {
    HorizontalPager(count = tabs.size, state = pagerState) { page ->
        tabs[page].screens()
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(tab: List<TabItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    TabRow(selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.White,
        indicator = { tabPositions ->
            Modifier.pagerTabIndicatorOffset(pagerState = pagerState,
                tabPositions = tabPositions
            )
        }
    ) {
        tab.forEachIndexed { index, tabItem ->
            LeadingIconTab(selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    Text(tabItem.title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal
                    )
                },
                icon = {}
            )
        }
    }
}
