package com.avlnv.booksappcompose.domain.model

interface Repository {

    suspend fun getWantToReadBooks(): Result<List<Book>>

}