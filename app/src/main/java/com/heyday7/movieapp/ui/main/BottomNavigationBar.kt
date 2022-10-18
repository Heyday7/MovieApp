package com.heyday7.movieapp.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigationScaffold(
    onHomeTabClick: () -> Unit,
    onSearchTabClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.padding(bottom = 40.dp)
        ) {
            content()
        }
        BottomNavigationBar(
            onHomeTabClick = onHomeTabClick,
            onSearchTabClick = onSearchTabClick
        )
    }
}

@Composable
private fun BoxScope.BottomNavigationBar(
    onHomeTabClick: () -> Unit,
    onSearchTabClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .height(40.dp)
            .background(Color.Black)
    ) {
        BottomNavigationItem(
            tab = Tab.Home,
            onClick = onHomeTabClick
        )
        BottomNavigationItem(
            tab = Tab.Search,
            onClick = onSearchTabClick
        )
    }
}


@Composable
private fun RowScope.BottomNavigationItem(
    tab: Tab,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .weight(1f)
            .height(40.dp)
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.requiredSize(20.dp),
            painter = painterResource(id = tab.icon),
            contentDescription = null,
            tint = Color.White
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = tab.title,
            color = Color.White
        )
    }
}