package com.avlnv.booksappcompose.data

import Flow.dictionary.ExampleJson2KtKotlinCloud
import retrofit2.http.GET

/*
https://openlibrary.org/people/mekBot/books/want-to-read.json
 */


interface ApiService {


    /*
    https://openlibrary.org/people/mekBot/books/want-to-read.json
     */
    @GET("people/mekBot/books/want-to-read.json")
    suspend fun getWantToReadBooks(): ExampleJson2KtKotlinCloud

    @GET("people/mekBot/books/want-to-read.json")
    suspend fun getCoverByCoverEditionKey(coverEditionKey: String): String

}