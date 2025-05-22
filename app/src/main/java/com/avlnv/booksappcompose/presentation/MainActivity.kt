package com.avlnv.booksappcompose.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.avlnv.booksappcompose.data.ApiFactory
import com.avlnv.booksappcompose.data.toBookModelList
import com.avlnv.booksappcompose.domain.model.Book
import com.avlnv.booksappcompose.ui.theme.BooksAppComposeTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val apiService = ApiFactory.apiService

        setContent {
            BooksAppComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val bookList = remember { mutableStateListOf<Book>() }

                    LaunchedEffect(Unit) {
                        val loadedList = withContext(Dispatchers.IO) {
                            apiService.getWantToReadBooks().readingLogEntries.toBookModelList()
                        }.take(10)

                        bookList.clear()
                        bookList.addAll(loadedList)
                    }

                    if (bookList.isNotEmpty()) Log.d("MainActivity", "${bookList[0]}")

                    BookList(
                        list = bookList,
                        padding = innerPadding,
                    )
                }
            }
        }
    }
}


@Composable
fun BookList(
    list: List<Book>,
    padding: PaddingValues
) {

    LazyColumn(
        modifier = Modifier.padding(padding)
    ) {
        items(
            items = list
        ) { book ->
            Spacer(Modifier.height(5.dp))
            BookScreen(book)
        }
    }

}