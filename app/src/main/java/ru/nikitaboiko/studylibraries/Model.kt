package ru.nikitaboiko.studylibraries

import io.reactivex.Completable
import io.reactivex.Observable

class Model {

    private val counters = ArrayList<Int>()

    init {
        for (i in 1..3) {
            counters.add(1)
        }
    }

    fun getAt(pos: Int): Observable<Int> {
        return Observable.create { subscriber ->
            subscriber.onNext(counters[pos])
        }
    }

    fun setAt(pos: Int, value: Int): Completable {
        return Completable.create {
            counters[pos] = value
        }
    }

}