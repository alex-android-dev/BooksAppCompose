package com.avlnv.data

import com.avlnv.domain.Repository

class RepositoryImpl : Repository {

    private val apiService = ApiFactory.apiService

    override suspend fun getWantToReadBooks(): Result<List<com.avlnv.domain.model.Book>> =
        runCatching {
            apiService.getWantToReadBooks().readingLogEntries.toBookModelList()
        }

}