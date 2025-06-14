package com.avlnv.feature_booklist.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun BookScreen(book: com.avlnv.domain.model.Book) {

    Row {
        AsyncImage(
            model = book.coverUrl,
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )

        Column {
            Text(book.title)
            Text(book.authorNames)
        }

    }

}

@Composable
@Preview
fun BookScreenPreview() {
    val coverUrl =
        "https://covers.openlibrary.org/b/olid/OL7440033M-M.jpg"

    val book = com.avlnv.domain.model.Book(
        title = "title",
        key = "",
        authorKeys = listOf(),
        authorNames = "author",
        firstPublishYear = 1998,
        localId = -1,
        coverUrl = coverUrl,
    )

    BookScreen(book)

}