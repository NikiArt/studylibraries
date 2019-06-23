package ru.nikitaboiko.studylibraries.task01

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface MainView : MvpView {
    fun setButtonOneText(value: Int)

    fun setButtonTwoText(value: Int)

    fun setButtonThreeText(value: Int)
}