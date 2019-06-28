package ru.nikitaboiko.studylibraries.task02

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import org.jetbrains.annotations.NotNull

class MyPublishSubject {
    private val publishSubject = PublishSubject.create<Any>()

    fun post(@NotNull event: Any) {
        if (this.publishSubject.hasObservers()) {
            this.publishSubject.onNext(event)
        }
    }

    fun observable(): Observable<Any> {
        return this.publishSubject
    }

}