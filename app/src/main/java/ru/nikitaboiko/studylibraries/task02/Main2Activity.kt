package ru.nikitaboiko.studylibraries.task02

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jakewharton.rxbinding3.widget.textChanges
import kotlinx.android.synthetic.main.activity_main2.*
import ru.nikitaboiko.studylibraries.R

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val textLabel = activity_main_two_text
        val editText = activity_main_two_edit
        editText.textChanges().subscribe() {
            textLabel.text = it.toString()
        }
    }
}
