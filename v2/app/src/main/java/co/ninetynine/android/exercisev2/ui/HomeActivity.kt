package co.ninetynine.android.exercisev2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.ninetynine.android.exercisev2.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        launchSearchActivity()
    }

    private fun launchSearchActivity() {
        // TODO: Go to search activity
    }

}
