package com.frenzelts.team99.listingdetail.view

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
import com.frenzelts.team99.common.adapter.BaseListAdapter
import com.frenzelts.team99.common.visitable.BaseTypeFactory
import com.frenzelts.team99.common.visitable.ErrorUiModel
import com.frenzelts.team99.common.visitable.LoadingUiModel
import com.frenzelts.team99.common.visitable.Visitable
import com.frenzelts.team99.databinding.ListingDetailPageBinding
import com.frenzelts.team99.listingdetail.di.DaggerListingDetailComponent
import com.frenzelts.team99.listingdetail.listener.ListingDetailCallback
import com.frenzelts.team99.listingdetail.view.adapter.ListingDetailItemDecoration
import com.frenzelts.team99.listingdetail.view.adapter.ListingDetailTypeFactoryImpl
import com.frenzelts.team99.listingdetail.viewmodel.ListingDetailViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class ListingDetailActivity: ComponentActivity() {

    private var _binding: ListingDetailPageBinding? = null
    private val binding: ListingDetailPageBinding
        get() = _binding!!
    private val adapter: BaseListAdapter by lazy { BaseListAdapter(
        ListingDetailTypeFactoryImpl(ListingDetailCallback(this))
    ) }
    private val layoutManager by lazy { LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) }

    private var listingId: Long = 0

    @Inject
    lateinit var viewModel: ListingDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()

        _binding = ListingDetailPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listingId = intent.getLongExtra(EXTRA_LISTING_ID, 0)

        setupStatusBar()
        setupBackButton()
        setupRecyclerView()
        requestData()
        observeData()
    }

    private fun setupStatusBar() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        window.statusBarColor = Color.TRANSPARENT
    }

    private fun setupBackButton() {
        binding.backButton.setOnClickListener {
            finish()
        }
    }

    private fun setupRecyclerView() {
        binding.rvListingDetail.adapter = adapter
        binding.rvListingDetail.layoutManager = layoutManager
        if(binding.rvListingDetail.itemDecorationCount == 0) {
            binding.rvListingDetail.addItemDecoration(ListingDetailItemDecoration)
        }
    }

    private fun requestData() {
        viewModel.fetchListingDetail(listingId)
    }

    private fun observeData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.listingDetail.collect {
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

    private fun inject() {
        DaggerListingDetailComponent.builder()
            .appComponent((application as BaseApplication).appComponent)
            .build()
            .inject(this)
    }

    companion object {
        const val EXTRA_LISTING_ID = "listingId"
    }
}