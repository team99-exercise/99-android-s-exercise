package com.catnip.hotelier.presentation.feature.searchresult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.catnip.hotelier.base.common.ui.ContentState
import com.catnip.hotelier.base.common.ui.toErrorContentState
import com.catnip.hotelier.base.core.proceedWhen
import com.catnip.hotelier.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchResultActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel: SearchResultViewModel by viewModel()

    private val adapter: SearchListAdapter by lazy {
        SearchListAdapter {
            Toast.makeText(this, it.id.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupList()
        getSearchListData()
    }

    private fun getSearchListData() {
        viewModel.searchResults.observe(this) {
            it.proceedWhen(
                doOnSuccess = {
                    binding.rvSearchResult.isVisible = true
                    binding.contentStateView.setState(ContentState.NORMAL)
                    it.payload?.let { result -> adapter.submitData(result) }
                },
                doOnError = {
                    binding.rvSearchResult.isVisible = false
                    it.exception?.toErrorContentState()?.let { e -> binding.contentStateView.setState(e) }
                },
                doOnEmpty = {
                    binding.rvSearchResult.isVisible = false
                    binding.contentStateView.setState(ContentState.EMPTY)
                },
                doOnLoading = {
                    binding.rvSearchResult.isVisible = false
                    binding.contentStateView.setState(ContentState.LOADING)
                }
            )
        }
    }

    private fun setupList() {
        binding.srlSearchResult.setOnRefreshListener {
            getSearchListData()
            binding.srlSearchResult.isRefreshing = false
        }
        binding.rvSearchResult.adapter = this@SearchResultActivity.adapter
    }
}