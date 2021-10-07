package co.ninetynine.android.exercisev2.search.ui

import android.os.Bundle
import co.ninetynine.android.exercisev2.search.databinding.ActivitySearchBinding
import co.ninetynine.android.exercisev2.ui.BaseActivity

class SearchActivity : BaseActivity<ActivitySearchBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerView()
        observeLiveData()
    }

    override fun createThisViewBinding() = ActivitySearchBinding.inflate(layoutInflater)

    private fun setupRecyclerView() {
        // TODO()
    }

    private fun observeLiveData() {
        // TODO()
    }

}
