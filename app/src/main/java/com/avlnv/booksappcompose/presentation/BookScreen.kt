package com.avlnv.booksappcompose.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.avlnv.booksappcompose.domain.model.Book

@Composable
fun BookScreen(book: Book) {

    Column {
        Text(book.title)
        Text(book.authorNames)
    }
    Spacer(Modifier.height((10.dp)))
}

@Composable
@Preview
fun BookScreenPreview() {

    val book = Book(
        title = "title",
        key = "",
        authorKeys = listOf(),
        authorNames = "author",
        firstPublishYear = 1998,
        localId = -1
    )

    BookScreen(book)

}