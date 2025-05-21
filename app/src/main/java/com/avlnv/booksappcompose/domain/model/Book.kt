package com.avlnv.booksappcompose.domain.model

data class Book(
    val title: String,
    val authorNames: String,
    val firstPublishYear: Int,
    val key: String,
    val authorKeys: String,
)
