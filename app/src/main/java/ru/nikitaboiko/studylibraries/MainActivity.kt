package ru.nikitaboiko.studylibraries

import android.os.Bundle
import android.view.View
import android.widget.Button
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), MainView, View.OnClickListener {
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
        buttonOne.setOnClickListener(this)
        buttonTwo.setOnClickListener(this)
        buttonThree.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == null) return
        presenter.counterClick(v.id)
    }

    override fun setButtonText(btnIndex: Int, value: Int) {
        val currentText = "Количество = $value"
        when (btnIndex) {
            0 -> buttonOne.text = currentText
            1 -> buttonTwo.text = currentText
            2 -> buttonThree.text = currentText
        }
    }
}
