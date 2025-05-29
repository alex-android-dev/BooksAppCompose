package com.avlnv.booksappcompose.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.avlnv.booksappcompose.R

@Composable
fun AppNavBar() {

    val routes = remember {
        listOf(
            R.drawable.ic_books,
            R.drawable.ic_search,
            R.drawable.ic_favorite,
            R.drawable.ic_account_avatar,
        )
    }

    NavigationBar(
        modifier = Modifier.fillMaxWidth()
    ) {
        NavigationBarItem(
            selected = TODO(),
            onClick = TODO(),
            icon = TODO(),
            modifier = TODO(),
            enabled = TODO(),
            label = TODO(),
            alwaysShowLabel = TODO(),
            colors = TODO(),
            interactionSource = TODO()
        )
    }

}


@Composable
@Preview
fun AppNavBarPreview() {

    AppNavBar()

}