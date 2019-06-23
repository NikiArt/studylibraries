package ru.nikitaboiko.studylibraries.task01

class Model {

    private val counters = ArrayList<Int>()

    init {
        for (i in 1..3) {
            counters.add(0)
        }
    }

    fun getAt(pos: Int): Int {
        return counters[pos]
    }

    fun setAt(pos: Int, value: Int) {
        counters[pos] = value
    }
}