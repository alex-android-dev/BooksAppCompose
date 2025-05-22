package com.avlnv.booksappcompose.domain.model

data class Book(
    val title: String,
    val key: String,
    val authorKeys: List<String>,
    val authorNames: String,
    val firstPublishYear: Int,
    val localId: Int = -1
)
