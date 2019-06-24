package ru.nikitaboiko.studylibraries

import android.app.Application
import io.reactivex.subjects.PublishSubject

class App : Application() {
    val publishSubject = PublishSubject.create<Int>()
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: App

        fun instance(): App {
            return instance
        }
    }
}