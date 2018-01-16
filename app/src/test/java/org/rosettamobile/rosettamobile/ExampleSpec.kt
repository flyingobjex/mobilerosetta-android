package org.rosettamobile.rosettamobile

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class ExampleSpec: StringSpec() {

    val example = Example()

    init {
        "parse json data from string" {
            val collection = example.parseTextToJson(jsonDataRaw)
            collection?.models?.count() shouldBe 2
        }
    }
}


val jsonDataRaw = """
{
    "title": "Main Collection",
    "models": [
        {
            "title": "First Model",
            "pageid": 2442
        },
        {
            "title": "Second Model",
            "pageid": 2553
        }
    ]
}
"""