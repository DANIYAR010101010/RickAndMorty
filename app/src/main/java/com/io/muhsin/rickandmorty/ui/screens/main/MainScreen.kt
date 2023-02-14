package com.io.muhsin.rickandmorty.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.LeadingIconTab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.*
import com.io.muhsin.rickandmorty.R
import com.io.muhsin.rickandmorty.ui.tablayout.TabItem
import kotlinx.coroutines.launch


@Composable
fun MainScreen() {
    Column {
        Row() {
            val textState = remember { mutableStateOf("") }
            TextField(value = textState.value,
                onValueChange = { textState.value },
                placeholder = { Text(text = "Введите текст") },
                modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 18.dp),
                leadingIcon = {
                    Image(painter = painterResource(id = R.drawable.ic_search_24),
                        contentDescription = "")
                }
            )
        }
        mainContent()
    }
}
@OptIn(ExperimentalPagerApi::class)
@Composable
fun mainContent(){
    val list = listOf(TabItem.Persons,TabItem.Locations,TabItem.Episodes)
    val pagerState = rememberPagerState()
    Column(Modifier.fillMaxSize()) {

        Tabs(list,pagerState =pagerState)
        tabContent(tabs = list, pagerState = pagerState)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun tabContent(tabs: List<TabItem>,pagerState: PagerState){
    HorizontalPager(count = tabs.size, state = pagerState) { page ->
        tabs[page].screens()
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(tab: List<TabItem>, pagerState: PagerState) {
    val scope  = rememberCoroutineScope()
    TabRow(selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.White,
        indicator = { tabPositions ->
            Modifier.pagerTabIndicatorOffset(pagerState = pagerState,
                tabPositions = tabPositions
            )
        }
    ) {
        tab.forEachIndexed { index, tabItem ->
            LeadingIconTab(selected = pagerState.currentPage==index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = { Text(tabItem.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                ) },
                icon = {}
            )
        }
    }
}