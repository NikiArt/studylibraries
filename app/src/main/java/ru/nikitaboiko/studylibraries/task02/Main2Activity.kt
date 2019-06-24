package ru.nikitaboiko.studylibraries.task02

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main2.*
import ru.nikitaboiko.studylibraries.App
import ru.nikitaboiko.studylibraries.R

class Main2Activity : AppCompatActivity() {
    lateinit var textLabel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        textLabel = activity_main_two_text
        val editText = activity_main_two_edit
        val button = activity_main_two_button

        button.setOnClickListener {
            App.instance().publishSubject.onNext((Math.random() * 1000).toInt())
        }

        editText.textChanges().subscribe() {
            textLabel.text = it.toString()
        }

        App.instance().publishSubject.subscribe(setLabelText())
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
                textLabel.text = value.toString()
            }
        }
    }
}