package ru.nikitaboiko.studylibraries


import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

@InjectViewState
class MainPresenter(val model: Model) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        val eventBus = PublishSubject.create<String>()
        eventBus.subscribe(object : Observer<String> {
            override fun onComplete() {
                Log.d("DDLog", "done")
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: String) {
                Log.d("DDLog", "first subscribe $t")
            }

            override fun onError(e: Throwable) {
            }

        })
        eventBus.onNext("a")
        eventBus.onNext("b")
        eventBus.subscribe(object : Observer<String> {
            override fun onComplete() {
                Log.d("DDLog", "done")
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: String) {
                Log.d("DDLog", "second subscribe $t")
            }

            override fun onError(e: Throwable) {
            }

        })
        eventBus.onNext("c")
        eventBus.onNext("d")
        eventBus.onComplete()
    }

    /*fun calcValue(index: Int): Observable<Int> {
        model.setAt()


        return Observable.create {
            ObservableOnSubscribe<Int> { emitter ->
                model.setAt(index, model.getAt(index) + 1)
                emitter.onNext(model.getAt(index))
            }
        }
    }*/

    fun counterClickButtonOne() {
        val usage = model.getAt(0)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                model.setAt(0, it + 1).subscribeOn(Schedulers.computation()).subscribe()
                viewState.setButtonOneText(it)
            }
    }

    fun counterClickButtonTwo() {
        val usage = model.getAt(1)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                model.setAt(1, it + 1).subscribeOn(Schedulers.computation()).subscribe()
                viewState.setButtonTwoText(it)
            }
    }

    fun counterClickButtonThree() {
        val usage = model.getAt(2)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                model.setAt(2, it + 1).subscribeOn(Schedulers.computation()).subscribe()
                viewState.setButtonThreeText(it)
            }
    }

}