package com.avlnv.domain

import com.avlnv.domain.model.Book

interface Repository {

    suspend fun getWantToReadBooks(): Result<List<Book>>

}