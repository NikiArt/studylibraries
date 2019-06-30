package ru.nikitaboiko.studylibraries

import android.os.Bundle
import android.widget.Button
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.jakewharton.rxbinding3.widget.textChanges
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), MainView {
    lateinit var buttonOne: Button
    lateinit var buttonTwo: Button
    lateinit var buttonThree: Button

    @InjectPresenter
    internal lateinit var presenter: MainPresenter


    @ProvidePresenter
    fun providePresenter(): MainPresenter {
        return MainPresenter(Model())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonOne = activity_main_button_one
        buttonTwo = activity_main_button_two
        buttonThree = activity_main_button_three
        buttonOne.text = getString(R.string.counter_format, 0)
        buttonTwo.text = getString(R.string.counter_format, 0)
        buttonThree.text = getString(R.string.counter_format, 0)
        buttonOne.setOnClickListener {
            presenter.counterClickButtonOne()
        }
        buttonTwo.setOnClickListener {
            presenter.counterClickButtonTwo()
        }
        buttonThree.setOnClickListener {
            presenter.counterClickButtonThree()
        }

        val textLabel = activity_main_text
        val editText = activity_main_edit
        editText.textChanges().subscribe {
            textLabel.text = it.toString()
        }
    }

    override fun setButtonOneText(value: Int) {
        buttonOne.text = getString(R.string.counter_format, value)
    }

    override fun setButtonTwoText(value: Int) {
        buttonTwo.text = getString(R.string.counter_format, value)
    }

    override fun setButtonThreeText(value: Int) {
        buttonThree.text = getString(R.string.counter_format, value)
    }
}
