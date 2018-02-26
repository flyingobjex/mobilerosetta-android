package org.mobilerosetta.mobilerosetta

import io.reactivex.subjects.BehaviorSubject

class RxObserverExample {

    val initialValue = Section("++", listOf(), listOf())
    val section = BehaviorSubject.create<Section>()
    
    init {
        section.onNext(initialValue)
        section.subscribe { // it:Section (current value in behavior subject)
            println("onNext() section heading = ${it.heading}")
            details =   "H:${it.heading?: "--"}, " +                // conditional assignment, elvis symbol
                        "S:${it.sections?.count()?: -1}, " +      // optional method call, optional assignment, elvis symbol
                        "P:${it.paragraphs.count()}"
        }
    }

    var details:String = "H:++, S:++, P:++"
        private set

    val description:String
        get() = "Details for section :: " + details  // getter shorthand
}