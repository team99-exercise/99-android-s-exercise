package co.ninetynine.android.exercise

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import co.ninetynine.android.exercise.formbuilder.FormBuilder
import co.ninetynine.android.exercise.util.Util
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

    private val formBuilder: FormBuilder by lazy {
        FormBuilder(this, rootLayout)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val page = Util.getSampleForm(this)
        page.logPage()
        formBuilder.build(page)
    }
}