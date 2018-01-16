package org.rosettamobile.rosettamobile

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi

data class TestModelCollection(val title:String?,
                               val pageid:Int = -1,
                               val models:List<TestModel>)

data class TestModel (
        val title:String = "none",
        val pageid:Int = -1)

class Example {

    fun parseTextToJson(text:String): TestModelCollection? {
        val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

        val jsonAdapter = moshi.adapter(TestModelCollection::class.java)
        try {
            val results = jsonAdapter.fromJson(text)
            if (results != null){
                return results
            }

        } catch (e:Exception) {
            println("!! Exception !! e.message = ${e.message}")
            println(e)
        }

        return null
    }
}
