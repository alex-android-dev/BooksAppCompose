package com.avlnv.booksappcompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    screenMain: @Composable () -> Unit,
    screenSearch: @Composable () -> Unit,
    screenFavorite: @Composable () -> Unit,
    screenProfile: @Composable () -> Unit,
) {

    NavHost(
        navController = navHostController,
        startDestination = Screen.ROUTE_MAIN,
    ) {

        composable(Screen.ROUTE_MAIN) {
            screenMain()
        }

        composable(Screen.ROUTE_SEARCH) {
            screenSearch()
        }

        composable(Screen.ROUTE_FAVORITE) {
            screenFavorite()
        }

        composable(Screen.ROUTE_PROFILE) {
            screenProfile()
        }

    }

}