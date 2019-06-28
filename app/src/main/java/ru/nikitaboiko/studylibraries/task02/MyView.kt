package ru.nikitaboiko.studylibraries.task02

import com.arellomobile.mvp.MvpView

interface MyView : MvpView {
    fun setTextLabel(text: String)
}