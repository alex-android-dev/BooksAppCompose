package com.avlnv.booksappcompose.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.avlnv.booksappcompose.domain.model.Book
import com.avlnv.booksappcompose.presentation.ScreenMain.ScreenMain


@Composable
fun NavHostApp(
    navHostController: NavHostController,
    bookList: List<Book>,
    padding: PaddingValues
) {

    NavHost(
        navController = navHostController,
        startDestination = Screen.ROUTE_MAIN
    ) {

        composable(Screen.ROUTE_MAIN) {
            ScreenMain(
                list = bookList,
                padding = padding,
            )
        }

        composable(Screen.ROUTE_SEARCH) {

        }

        composable(Screen.ROUTE_FAVORITE) {

        }

        composable(Screen.ROUTE_PROFILE) {

        }

    }

}