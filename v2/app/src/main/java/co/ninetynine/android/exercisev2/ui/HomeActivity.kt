package co.ninetynine.android.exercisev2.ui

import android.os.Bundle
import co.ninetynine.android.exercisev2.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launchSearchActivity()
    }

    override fun createThisViewBinding() = ActivityHomeBinding.inflate(layoutInflater)

    private fun launchSearchActivity() {
        // TODO: Go to search activity
    }

}
