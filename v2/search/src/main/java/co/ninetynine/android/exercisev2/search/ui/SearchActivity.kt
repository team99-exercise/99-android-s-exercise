package co.ninetynine.android.exercisev2.search.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import co.ninetynine.android.exercisev2.search.databinding.ActivitySearchBinding
import co.ninetynine.android.exercisev2.search.model.ListingItem
import co.ninetynine.android.exercisev2.search.viewmodel.SearchViewModel
import co.ninetynine.android.exercisev2.search.viewmodel.SearchViewModelFactory
import co.ninetynine.android.exercisev2.ui.BaseActivity

class SearchActivity : BaseActivity<ActivitySearchBinding>() {

    private val viewModel by lazy {
        val factory = SearchViewModelFactory(application)
        ViewModelProvider(this, factory)[SearchViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupSearchList()
        observeLiveData()
    }

    override fun createThisViewBinding() = ActivitySearchBinding.inflate(layoutInflater)

    private fun setupSearchList() {
        getThisViewBinding().searchResultsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = SearchAdapter(context)
        }
    }

    private fun observeLiveData() {
        viewModel.listingItems.observeNotNull {
            onSearchItemsChanged(it)
        }
    }

    private fun onSearchItemsChanged(items: List<ListingItem>) {
        getSearchListAdapter().setSearchItems(items)
    }

    private fun getSearchListAdapter() = getThisViewBinding()
        .searchResultsList.adapter as SearchAdapter

}
