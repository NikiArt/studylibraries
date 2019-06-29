package ru.nikitaboiko.studylibraries.task02

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

@InjectViewState
class MyPresenter(val model: MyModel) : MvpPresenter<MyView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun setLabelText(): Observer<Int> {
        return object : Observer<Int> {
            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onError(e: Throwable) {
            }

            override fun onNext(value: Int) {
                //viewState.setTextLabel()
            }
        }
    }
}