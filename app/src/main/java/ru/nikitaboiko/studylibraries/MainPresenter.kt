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

    fun counterClick(id: Int) {
        when (id) {
            R.id.activity_main_button_one -> viewState.setButtonText(0, calcValue(0))
            R.id.activity_main_button_two -> viewState.setButtonText(1, calcValue(1))
            R.id.activity_main_button_three -> viewState.setButtonText(2, calcValue(2))
        }
    }
}