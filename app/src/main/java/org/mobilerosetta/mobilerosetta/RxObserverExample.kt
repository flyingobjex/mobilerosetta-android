package org.mobilerosetta.mobilerosetta

import io.reactivex.subjects.BehaviorSubject

class RxObserverExample {

    val section = BehaviorSubject.create<Section>()
    
    init {
        section.subscribe { p ->
            println("RxObserverExample.subscribe{} p.body = ${p.heading}")
        }
    }
}