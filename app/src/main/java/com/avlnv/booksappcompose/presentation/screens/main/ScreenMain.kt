package com.avlnv.booksappcompose.presentation.screens.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.avlnv.booksappcompose.domain.model.Book
import com.avlnv.booksappcompose.presentation.BookScreen

@Composable
fun ScreenMain(
    list: List<Book>,
    paddingValues: PaddingValues,
) {

    LazyColumn(
        modifier = Modifier.padding(paddingValues)
    ) {
        items(
            items = list
        ) { book ->
            Spacer(Modifier.height(5.dp))
            BookScreen(book)
        }
    }

}