package com.avlnv.booksappcompose.data

import Flow.dictionary.ReadingLogEntriesCloud
import Flow.dictionary.WorkCloud
import com.avlnv.booksappcompose.domain.model.Book

/**
 * mapper [WorkCloud]
 */

fun WorkCloud.toBookModel() = Book(
    title = this.title ?: "",
    key = this.key ?: "",
    authorKeys = this.authorKeys,
    authorNames = this.authorNames.joinToString(),
    firstPublishYear = this.firstPublishYear ?: 0,
)

fun List<ReadingLogEntriesCloud>.toBookModelList() = this.map { it.workCloud.toBookModel() }


