package com.avlnv.feature_booklist.main

import com.avlnv.domain.model.Book

sealed class ScreenStateBookList {

    data object Initial : ScreenStateBookList()
    data class Error(val message: String) : ScreenStateBookList()
    data object Loading : ScreenStateBookList()
    data class Success(val list: List<Book>) : ScreenStateBookList()

}