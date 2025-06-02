package com.avlnv.booksappcompose.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.avlnv.booksappcompose.presentation.navigation.NavigationItem
import com.avlnv.booksappcompose.presentation.navigation.NavigationState

@Composable
fun AppNavBottomBar(
    navigationState: NavigationState,
) {

    val routes = remember {
        listOf(
            NavigationItem.Main,
            NavigationItem.Search,
            NavigationItem.Favorite,
            NavigationItem.Profile
        )
    }

    NavigationBar(
        modifier = Modifier.fillMaxWidth()
    ) {

        /** Хранит текущий стейт экрана */
        val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()

        routes.forEach { route ->

            val selected = navBackStackEntry?.destination?.hierarchy?.any() {
                it.route == route.screen.route
            } ?: false

            val icon = painterResource(route.icon)
            val text = stringResource(route.titleResId)

            NavigationBarItem(
                selected = selected,
                onClick = {
                    if (!selected) navigationState.navigateTo(route.screen.route)
                },
                icon = {
                    Icon(
                        painter = icon,
                        contentDescription = text,
                    )
                },
                label = {
                    Text(text)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                    unselectedIconColor = MaterialTheme.colorScheme.onBackground,
                    indicatorColor = MaterialTheme.colorScheme.onBackground
                )
            )
        }
    }
}