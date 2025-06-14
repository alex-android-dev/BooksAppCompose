package com.avlnv.domain.model

data class Book(
    val title: String,
    val key: String,
    val authorKeys: List<String>,
    val authorNames: String,
    val firstPublishYear: Int,
    val coverUrl: String,
    val localId: Int = -1
)
