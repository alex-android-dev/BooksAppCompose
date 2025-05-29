package com.avlnv.booksappcompose.presentation.navigation

import okhttp3.Route

sealed class Screen(
    route: String,
) {

    data object Main : Screen(ROUTE_MAIN)
    data object Search : Screen(ROUTE_SEARCH)
    data object Favorite : Screen(ROUTE_FAVORITE)
    data object Profile : Screen(ROUTE_PROFILE)

    companion object {
        const val ROUTE_MAIN = "main"
        const val ROUTE_SEARCH = "search"
        const val ROUTE_FAVORITE = "favorite"
        const val ROUTE_PROFILE = "profile"
    }

}