package org.mobilerosetta.mobilerosetta

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class RxObserverExampleSpec : StringSpec() {

    init {

        "given an observable paragraph, when an update is made, the code block should run" {
            val example = RxObserverExample()
            example.section.subscribe {
                 it.description shouldBe "H:H1, S:0, P:0"
            }

            example.section.onNext(Section("H1", listOf(), listOf()))
        }

        "given an Section with a null heading, it should return '--'" {
            val example = RxObserverExample()
            example.section.subscribe { sec ->
                sec.description shouldBe "H:--, S:1, P:0"
            }

            val s = Section(null, listOf(),
                        listOf(Section(null, listOf(), listOf())))

            example.section.onNext(s)
        }

        "optional code block should execute" {
            val example = RxObserverExample()
            example.section.subscribe {
                it.heading?.let { h -> // optional code block, optional let
                  h shouldBe "H3"
                }
            }

            example.section.onNext(Section("H3", listOf(), listOf()))
        }
    }
}