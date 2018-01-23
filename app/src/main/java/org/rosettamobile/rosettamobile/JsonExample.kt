package org.rosettamobile.rosettamobile

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi

/**
 * @param title mapped directly from JSON object.
 * @param pageid mapped directly from JSON object.
 * @param entry_list indirectly mapped, private to encapsulate unused json name
 * @property entries custom mapping from JSON object.
 * @constructor Invoked directly in Moshi.Builder() using json adaptor.
 */
data class PageCollection(val title:String?,
                          val pageid:Int = -1,
                          private val entry_list:List<Page>) {

    val entries = entry_list // direct mapping in lieu of @Json meta tags
}

data class Page(
        val title:String = "none",
        val pageid:Int = -1,
        val author:Author?)

data class Author(
        val name:String?,
        private val author_id:Int?) {

    val id = author_id // direct mapping in lieu of @Json meta tags
}

class JsonExample {

    fun parseTextToJson(text:String): PageCollection? {
        val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

        val jsonAdapter = moshi.adapter(PageCollection::class.java)
        try {

            jsonAdapter.fromJson(text)?.let { return it }

        } catch (e:Exception) {
            println("!! Exception !! e.message = ${e.message}")
            println(e)
        }

        return null
    }
}
