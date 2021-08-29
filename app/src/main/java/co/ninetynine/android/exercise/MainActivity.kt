package co.ninetynine.android.exercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.ninetynine.android.exercise.adapters.SectionsListAdapter
import co.ninetynine.android.exercise.databinding.ActivityMainBinding
import co.ninetynine.android.exercise.util.Util.getSampleForm

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSampleForm(this)?.let { page ->
            page.logPage()
            binding.title.text = page.title
            binding.sections.adapter = SectionsListAdapter(page.sections)
        }
    }
}