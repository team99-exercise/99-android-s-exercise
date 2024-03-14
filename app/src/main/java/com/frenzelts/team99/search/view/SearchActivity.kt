package com.frenzelts.team99.search.view

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.frenzelts.team99.common.BaseApplication
import com.frenzelts.team99.common.Result
import com.frenzelts.team99.common.visitable.BaseTypeFactory
import com.frenzelts.team99.common.visitable.ErrorUiModel
import com.frenzelts.team99.common.visitable.LoadingUiModel
import com.frenzelts.team99.common.visitable.Visitable
import com.frenzelts.team99.databinding.SearchPageBinding
import com.frenzelts.team99.search.di.DaggerSearchComponent
import com.frenzelts.team99.search.view.adapter.SearchItemDecoration
import com.frenzelts.team99.common.adapter.BaseListAdapter
import com.frenzelts.team99.search.view.adapter.SearchTypeFactoryImpl
import com.frenzelts.team99.search.view.listener.ListingItemCallback
import com.frenzelts.team99.search.viewmodel.SearchViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchActivity: ComponentActivity() {

    private var _binding: SearchPageBinding? = null
    private val binding: SearchPageBinding
        get() = _binding!!
    private val adapter: BaseListAdapter by lazy { BaseListAdapter(
        SearchTypeFactoryImpl(ListingItemCallback(this))
    ) }
    private val layoutManager by lazy { LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) }

    @Inject
    lateinit var viewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()

        _binding = SearchPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupStatusBar()
        setupRecyclerView()
        requestData()
        observeData()
    }

    private fun inject() {
        DaggerSearchComponent.builder()
            .appComponent((application as BaseApplication).appComponent)
            .build()
            .inject(this)
    }

    private fun setupStatusBar() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.TRANSPARENT
    }

    private fun setupRecyclerView() {
        binding.rvSearch.adapter = adapter
        binding.rvSearch.layoutManager = layoutManager
        if(binding.rvSearch.itemDecorationCount == 0) {
            binding.rvSearch.addItemDecoration(SearchItemDecoration)
        }
    }

    private fun requestData() {
        viewModel.fetchSearchResult()
    }

    private fun observeData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.listing.collect {
                    when(it.status) {
                        Result.Status.LOADING -> {
                            adapter.submitList(listOf(LoadingUiModel()))
                        }
                        Result.Status.ERROR -> {
                            adapter.submitList(listOf(ErrorUiModel()))
                        }
                        else -> {
                            adapter.submitList(it.data as? List<Visitable<BaseTypeFactory>>)
                        }
                    }
                }
            }
        }
    }
}