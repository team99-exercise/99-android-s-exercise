package com.team99.exerciserhony.data.repository

import com.team99.exerciserhony.data.service.PropertyService
import com.team99.exerciserhony.domain.entity.Property
import com.team99.exerciserhony.domain.entity.PropertyDetail
import com.team99.exerciserhony.domain.repository.PropertyRepository
import com.team99.exerciserhony.utils.DispatcherProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class PropertyRepositoryImpl @Inject constructor(
    private val service: PropertyService,
    private val dispatcher: DispatcherProvider
) : PropertyRepository {

    override fun getPropertyList(): Flow<List<Property>> = flow {
        emit(service.getPropertyList())
    }.flowOn(dispatcher.io)

    override fun getDetailProperty(id: Int): Flow<PropertyDetail> = flow {
        emit(service.getPropertyDetail())
    }.flowOn(dispatcher.io)

}
