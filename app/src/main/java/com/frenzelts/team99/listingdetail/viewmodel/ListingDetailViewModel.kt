package com.frenzelts.team99.listingdetail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frenzelts.team99.common.Result
import com.frenzelts.team99.listingdetail.domain.ListingDetailMapper.mapToUiModel
import com.frenzelts.team99.listingdetail.domain.ListingDetailRepository
import com.frenzelts.team99.listingdetail.view.model.ListingDetailVisitable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class ListingDetailViewModel @Inject constructor(
    private val listingDetailRepository: ListingDetailRepository,
): ViewModel() {

    private val _listingDetail: MutableStateFlow<Result<List<ListingDetailVisitable>>> = MutableStateFlow(Result.loading())
    val listingDetail: StateFlow<Result<List<ListingDetailVisitable>>> = _listingDetail.asStateFlow()

    fun fetchListingDetail(id: Long) {
        _listingDetail.postLoading()
        viewModelScope.launch {
            try {
                val response = listingDetailRepository.fetchRemote(id)
                _listingDetail.value = Result.success(response.mapToUiModel())
            } catch (e: Exception) {
                _listingDetail.postError(e)
            }
        }
    }

    private fun MutableStateFlow<Result<List<ListingDetailVisitable>>>.postError(e: Throwable) {
        value = Result.error(e)
    }

    private fun MutableStateFlow<Result<List<ListingDetailVisitable>>>.postLoading() {
        value = Result.loading()
    }
}