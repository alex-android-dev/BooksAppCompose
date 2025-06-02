package com.avlnv.booksappcompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class NavigationState(
    val navHostController: NavHostController,
) {

    fun navigateTo(route: String) {
        navHostController.navigate(route) {
            /** Предотвращает дублирование экранов */
            launchSingleTop = true

            /** Восстанавливает состояние экрана */
            restoreState = true
        }
    }
}


/**
 * Позволяет создать внутри себя стейт, который инкапсулирует и меняет логику работы [NavHostController]
 */

@Composable
fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController()
): NavigationState = remember {
    NavigationState(navHostController)
}