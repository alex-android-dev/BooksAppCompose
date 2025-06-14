package com.avlnv.booksappcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.MutableCreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.avlnv.data.RepositoryImpl
import com.avlnv.booksappcompose.presentation.navigation.AppNavGraph
import com.avlnv.booksappcompose.presentation.navigation.rememberNavigationState
import com.avlnv.booksappcompose.ui.theme.BooksAppComposeTheme
import com.avlnv.feature_booklist.main.BookListViewModel
import com.avlnv.feature_booklist.main.ScreenMain

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val repository = RepositoryImpl()

        setContent {
            val viewModel: BookListViewModel = viewModel(
                factory = BookListViewModel.Factory,
                extras = MutableCreationExtras().apply {
                    set(BookListViewModel.ARG_REPOSITORY, repository)
                }
            )

            val navState = rememberNavigationState()

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
                                viewModel = viewModel,
                                paddingValues = innerPadding,
                            )
                        },

                        screenSearch = {
                            com.avlnv.feature_search.ScreenSearch(innerPadding)
                        },

                        screenFavorite = {
                            com.avlnv.feature_favorite.ScreenFavorite(innerPadding)
                        },

                        screenProfile = {
                            com.avlnv.feature_profile.ScreenProfile(innerPadding)
                        },
                    )
                }
            }
        }
    }
}


