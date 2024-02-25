package com.team99.exerciserhony.domain.repository

import com.team99.exerciserhony.domain.entity.Property
import com.team99.exerciserhony.domain.entity.PropertyDetail
import kotlinx.coroutines.flow.Flow

interface PropertyRepository {
    fun getPropertyList(): Flow<List<Property>>
    fun getDetailProperty(id: Int): Flow<PropertyDetail>
}
