package com.frenzelts.team99.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frenzelts.team99.common.Result
import com.frenzelts.team99.common.visitable.ErrorUiModel
import com.frenzelts.team99.search.domain.SearchMapper.mapToUiModel
import com.frenzelts.team99.search.domain.SearchRepository
import com.frenzelts.team99.search.view.model.ListingUiModel
import com.frenzelts.team99.search.view.model.SearchVisitable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository,
): ViewModel() {

    private val _listing: MutableStateFlow<Result<List<SearchVisitable>>> = MutableStateFlow(Result.loading())
    val listing: StateFlow<Result<List<SearchVisitable>>> = _listing.asStateFlow()

    fun fetchSearchResult() {
        _listing.postLoading()
        viewModelScope.launch {
            try {
                val response = searchRepository.fetchRemote()
                _listing.value = Result.success(response.map { it.mapToUiModel() })
            } catch (e: Exception) {
                _listing.postError(e)
            }
        }
    }

    private fun MutableStateFlow<Result<List<SearchVisitable>>>.postError(e: Throwable) {
        value = Result.error(e)
    }

    private fun MutableStateFlow<Result<List<SearchVisitable>>>.postLoading() {
        value = Result.loading()
    }
}