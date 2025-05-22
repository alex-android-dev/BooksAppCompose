package com.avlnv.booksappcompose.data

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val result = async {
        val result = ApiFactory.apiService.getWantToReadBooks().readingLogEntries
        result
    }
    println(result.await())
}