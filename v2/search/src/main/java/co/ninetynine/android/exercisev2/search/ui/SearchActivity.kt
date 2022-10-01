package co.ninetynine.android.exercisev2.search.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import co.ninetynine.android.exercisev2.di.SearchModuleDependencies
import co.ninetynine.android.exercisev2.search.databinding.ActivitySearchBinding
import co.ninetynine.android.exercisev2.search.di.DaggerSearchComponent
import co.ninetynine.android.exercisev2.search.model.ListingItem
import co.ninetynine.android.exercisev2.search.viewmodel.SearchViewModel
import co.ninetynine.android.exercisev2.search.viewmodel.SearchViewModelFactory
import co.ninetynine.android.exercisev2.ui.BaseActivity
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class SearchActivity : BaseActivity<ActivitySearchBinding>() {

    @Inject
    lateinit var viewModelFactory: SearchViewModelFactory
    private val viewModel by viewModels<SearchViewModel>(factoryProducer = { viewModelFactory })

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        setupSearchList()
        observeLiveData()
    }

    private fun injectDependencies() {
        DaggerSearchComponent.factory().create(
            EntryPointAccessors.fromApplication(
                applicationContext,
                SearchModuleDependencies::class.java
            )
        ).inject(this)
    }

    override fun createThisViewBinding() = ActivitySearchBinding.inflate(layoutInflater)

    private fun setupSearchList() {
        getThisViewBinding().searchResultsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = SearchAdapter()
        }
    }

    private fun observeLiveData() {
        viewModel.listingItems.observeNotNull { state ->
            getThisViewBinding().loading.isVisible = state.isLoading
            state.data?.let(::onSearchItemsChanged)
            state.error?.let(::showError)
        }
    }

    private fun onSearchItemsChanged(items: List<ListingItem>) {
        getSearchListAdapter().submitList(items)
    }

    private fun getSearchListAdapter() = getThisViewBinding()
        .searchResultsList.adapter as SearchAdapter

    private fun showError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }
}
