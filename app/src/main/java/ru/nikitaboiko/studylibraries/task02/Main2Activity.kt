package ru.nikitaboiko.studylibraries.task02

import android.os.Bundle
import android.widget.TextView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.jakewharton.rxbinding3.widget.textChanges
import kotlinx.android.synthetic.main.activity_main2.*
import ru.nikitaboiko.studylibraries.App
import ru.nikitaboiko.studylibraries.R
import ru.nikitaboiko.studylibraries.task01.MainPresenter
import ru.nikitaboiko.studylibraries.task01.Model

class Main2Activity : MvpAppCompatActivity(), MyView {
    lateinit var textLabel: TextView
    @InjectPresenter
    internal lateinit var presenter: MyPresenter

    @ProvidePresenter
    fun providePresenter(): MainPresenter {
        return MainPresenter(Model())
    }

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

        //App.instance().publishSubject.subscribe(presenter.setLabelText())
    }

    override fun setTextLabel(text: String) {
        textLabel.text = text
    }


}