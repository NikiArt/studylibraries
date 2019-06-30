package ru.nikitaboiko.studylibraries

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import org.jetbrains.annotations.NotNull

class MyEventBus {

    private val bus: Subject<Any> = PublishSubject.create()

    fun post(@NotNull event: Any) {
        if (this.bus.hasObservers()) {
            this.bus.onNext(event)
        }
    }

    fun observable(): Observable<Any> {
        return this.bus
    }
}