package com.avlnv.booksappcompose.presentation.screens.main

import com.avlnv.booksappcompose.domain.model.Book

sealed class ScreenStateBookList {

    data object Initial : ScreenStateBookList()
    data class Error(val message: String) : ScreenStateBookList()
    data object Loading : ScreenStateBookList()
    data class Success(val list: List<Book>) : ScreenStateBookList()

}