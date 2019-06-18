package ru.nikitaboiko.studylibraries

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonOne = activity_main_button_one
        val buttonTwo = activity_main_button_two
        val buttonThree = activity_main_button_three

        buttonOne.setOnClickListener { v: View ->


        }
        buttonTwo.setOnClickListener {

        }
        buttonThree.setOnClickListener {

        }
    }

    override fun setButtonText(btnIndex: Int, value: Int) {
        1
    }
}
