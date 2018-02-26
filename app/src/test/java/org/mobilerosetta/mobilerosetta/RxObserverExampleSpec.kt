package org.mobilerosetta.mobilerosetta

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class RxObserverExampleSpec : StringSpec() {

    init {

        "given an observable Section, when an update is made, the code block should run" {
            val example = RxObserverExample()
            example.details shouldBe "H:++, S:++, P:++"

            var values = ""  // collects the values of subscription during test
            example.section.subscribe {
                values += it.heading + ","
            }

            example.section.onNext(Section("H1", listOf(Paragraph(1,"")), listOf()))
            example.details shouldBe "H:H1, S:0, P:1"

            example.section.onNext(Section("H2", listOf(Paragraph(2,"")), listOf()))
            example.description shouldBe "Details for section :: H:H2, S:0, P:1"

            values shouldBe "++,H1,H2,"
        }

    }
}