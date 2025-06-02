package com.avlnv.booksappcompose.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.avlnv.booksappcompose.R

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val icon: Int,
) {
    data object Main : NavigationItem(Screen.Main, R.string.main, R.drawable.ic_books)
    data object Search : NavigationItem(Screen.Search, R.string.search, R.drawable.ic_search)
    data object Favorite :
        NavigationItem(Screen.Favorite, R.string.favorite, R.drawable.ic_favorite)

    data object Profile :
        NavigationItem(Screen.Profile, R.string.profile, R.drawable.ic_account_avatar)

}