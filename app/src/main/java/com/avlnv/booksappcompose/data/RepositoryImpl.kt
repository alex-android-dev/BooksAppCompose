package com.avlnv.booksappcompose.data

import com.avlnv.booksappcompose.domain.model.Book
import com.avlnv.booksappcompose.domain.model.Repository

class RepositoryImpl : Repository {

    private val apiService = ApiFactory.apiService

    override suspend fun getWantToReadBooks(): Result<List<Book>> =
        runCatching {
            apiService.getWantToReadBooks().readingLogEntries.toBookModelList()
        }

}