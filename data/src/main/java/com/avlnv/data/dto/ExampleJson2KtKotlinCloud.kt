package Flow.dictionary

import com.google.gson.annotations.SerializedName


data class ExampleJson2KtKotlinCloud(
    @SerializedName("reading_log_entries") val readingLogEntries: List<ReadingLogEntriesCloud?> = arrayListOf()
)