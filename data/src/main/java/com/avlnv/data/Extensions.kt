package com.avlnv.data

import Flow.dictionary.ReadingLogEntriesCloud
import Flow.dictionary.WorkCloud
import com.avlnv.domain.model.Book

/**
 * mapper [WorkCloud]
 */

// https://covers.openlibrary.org/b/olid/OL27333509M-M.jpg

// cover_edition_key OL27333509M

const val COVER_URL = "https://covers.openlibrary.org/b/olid/"
const val M_SIZE = "-M"
const val JPG_FORMAT = ".jpg"

fun WorkCloud.toBookModel() = com.avlnv.domain.model.Book(
    title = this.title ?: "",
    key = this.key ?: "",
    authorKeys = this.authorKeys,
    authorNames = this.authorNames.joinToString(),
    firstPublishYear = this.firstPublishYear ?: 0,
    coverUrl = createCoverUrl(this.coverEditionKey),
)

fun List<ReadingLogEntriesCloud>.toBookModelList() = this.map { it.workCloud.toBookModel() }


private fun createCoverUrl(coverEditionKey: String) = buildString {
    append(COVER_URL)
    append(coverEditionKey)
    append(M_SIZE)
    append(JPG_FORMAT)
}



