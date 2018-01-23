package org.rosettamobile.rosettamobile

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi

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
