package Flow.dictionary

import com.google.gson.annotations.SerializedName

data class WorkCloud(
    @SerializedName("title") val title: String? = null,
    @SerializedName("key") val key: String? = null,
    @SerializedName("author_keys") val authorKeys: List<String> = arrayListOf(),
    @SerializedName("author_names") val authorNames: List<String> = arrayListOf(),
    @SerializedName("first_publish_year") val firstPublishYear: Int? = null,
    @SerializedName("lending_edition_s") val lendingEditionS: String? = null,
    @SerializedName("edition_key") val editionKey: List<String> = arrayListOf(),
    @SerializedName("cover_id") val coverId: Long? = null,
    @SerializedName("cover_edition_key") val coverEditionKey: String
)