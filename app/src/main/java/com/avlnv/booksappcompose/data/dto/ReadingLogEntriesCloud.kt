package Flow.dictionary

import com.google.gson.annotations.SerializedName


data class ReadingLogEntriesCloud(
    @SerializedName("work") val workCloud: WorkCloud
)