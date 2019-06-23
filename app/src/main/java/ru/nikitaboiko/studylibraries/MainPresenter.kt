package ru.nikitaboiko.studylibraries

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class MainPresenter(val model: Model) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun calcValue(index: Int): Int {
        model.setAt(index, model.getAt(index) + 1)
        return model.getAt(index)
    }

    fun counterClickButtonOne() {
        viewState.setButtonOneText(calcValue(0))
    }

    fun counterClickButtonTwo() {
        viewState.setButtonTwoText(calcValue(1))
    }

    fun counterClickButtonThree() {
        viewState.setButtonThreeText(calcValue(2))
    }
}