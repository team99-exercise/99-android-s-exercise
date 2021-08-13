package co.ninetynine.android.exercise.features

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.ninetynine.android.exercise.R
import co.ninetynine.android.exercise.databinding.ActivityMainBinding
import co.ninetynine.android.exercise.util.Util

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Util.getSampleForm(this).logPage()
    }

}