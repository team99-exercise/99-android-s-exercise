package co.ninetynine.android.exercisev2.ui

import android.content.Intent
import android.os.Bundle
import co.ninetynine.android.exercisev2.BuildConfig
import co.ninetynine.android.exercisev2.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launchSearchActivity()
    }

    override fun createThisViewBinding() = ActivityHomeBinding.inflate(layoutInflater)

    private fun launchSearchActivity() {
        val intent = Intent(Intent.ACTION_VIEW).setClassName(
            BuildConfig.APPLICATION_ID,
            "co.ninetynine.android.exercisev2.search.ui.SearchActivity"
        )
        startActivity(intent)
    }

}
