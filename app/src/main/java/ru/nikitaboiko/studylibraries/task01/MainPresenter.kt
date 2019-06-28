package ru.nikitaboiko.studylibraries.task01


import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

@InjectViewState
class MainPresenter(val model: Model) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun calcValue(index: Int): Observable<Int> {
        return Observable.create {
            ObservableOnSubscribe<Int> { emitter ->
                model.setAt(index, model.getAt(index) + 1)
                emitter.onNext(model.getAt(index))
            }
        }
    }

    fun counterClickButtonOne() {
        val observer = object : Observer<Int> {
            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Int) {
            }

            override fun onError(e: Throwable) {
            }

        }

        // viewState.setButtonOneText(calcValue(0))
    }

    fun counterClickButtonTwo() {
        // viewState.setButtonTwoText(calcValue(1))
    }

    fun counterClickButtonThree() {
        //viewState.setButtonThreeText(calcValue(2))
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
                viewState.
            }
        }
    }
}