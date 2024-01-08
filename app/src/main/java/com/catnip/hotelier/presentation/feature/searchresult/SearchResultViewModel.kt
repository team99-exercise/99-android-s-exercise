package com.catnip.hotelier.presentation.feature.searchresult

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.catnip.hotelier.base.core.ResultWrapper
import com.catnip.hotelier.domain.usecase.GetPlaceUseCase
import com.catnip.hotelier.presentation.model.Place
import kotlinx.coroutines.Dispatchers

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class SearchResultViewModel(private val getPlaceUseCase: GetPlaceUseCase) : ViewModel() {
    val searchResults: LiveData<ResultWrapper<List<Place>>>
        get() = getPlaceUseCase.proceed().asLiveData(Dispatchers.IO)
}