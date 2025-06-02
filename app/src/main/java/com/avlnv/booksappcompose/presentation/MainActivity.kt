package com.avlnv.booksappcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.avlnv.booksappcompose.data.ApiFactory
import com.avlnv.booksappcompose.data.toBookModelList
import com.avlnv.booksappcompose.domain.model.Book
import com.avlnv.booksappcompose.presentation.navigation.AppNavGraph
import com.avlnv.booksappcompose.presentation.navigation.rememberNavigationState
import com.avlnv.booksappcompose.presentation.screens.favorite.ScreenFavorite
import com.avlnv.booksappcompose.presentation.screens.main.ScreenMain
import com.avlnv.booksappcompose.presentation.screens.profile.ScreenProfile
import com.avlnv.booksappcompose.presentation.screens.search.ScreenSearch
import com.avlnv.booksappcompose.ui.theme.BooksAppComposeTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val apiService = ApiFactory.apiService

        setContent {
            val bookList = remember { mutableStateListOf<Book>() }
            val navState = rememberNavigationState()

            LaunchedEffect(Unit) {
                val loadedList = withContext(Dispatchers.IO) {
                    apiService.getWantToReadBooks().readingLogEntries.toBookModelList()
                }.take(10)

                bookList.clear()
                bookList.addAll(loadedList)
            }

            BooksAppComposeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        AppNavBottomBar(navState)
                    }
                ) { innerPadding ->

                    AppNavGraph(
                        navHostController = navState.navHostController,

                        screenMain = {
                            ScreenMain(
                                list = bookList,
                                paddingValues = innerPadding,
                            )
                        },

                        screenSearch = {
                            ScreenSearch(innerPadding)
                        },

                        screenFavorite = {
                            ScreenFavorite(innerPadding)
                        },

                        screenProfile = {
                            ScreenProfile(innerPadding)
                        },
                    )
                }
            }
        }
    }
}


