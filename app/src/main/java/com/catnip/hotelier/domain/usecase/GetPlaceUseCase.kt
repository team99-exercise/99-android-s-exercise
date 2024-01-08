package com.catnip.hotelier.domain.usecase

import com.catnip.hotelier.base.core.UseCase
import com.catnip.hotelier.base.core.ResultWrapper
import com.catnip.hotelier.base.core.mapMutate
import com.catnip.hotelier.data.repository.PlaceRepository
import com.catnip.hotelier.domain.mapper.toPlaces
import com.catnip.hotelier.presentation.model.Place
import kotlinx.coroutines.flow.Flow

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class GetPlaceUseCase(
    private val repository: PlaceRepository
) : UseCase<Flow<ResultWrapper<List<Place>>>> {
    override fun proceed(params : Any?): Flow<ResultWrapper<List<Place>>> {
        return repository.getPlaces().mapMutate { it?.toPlaces() }
    }
}