package com.team99.exerciserhony.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team99.exerciserhony.domain.entity.Property
import com.team99.exerciserhony.domain.entity.PropertyDetail
import com.team99.exerciserhony.domain.repository.PropertyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertyViewModel @Inject constructor(
    private val repository: PropertyRepository
) : ViewModel() {

    private val _propertyList = MutableStateFlow(emptyList<Property>())
    val propertyList = _propertyList.asStateFlow()

    private val _propertyDetail = MutableStateFlow(PropertyDetail.EMPTY)
    val propertyDetail = _propertyDetail.asStateFlow()

    fun getPropertyList() {
        viewModelScope.launch {
            repository.getPropertyList().collect {
                Log.d(
                    "PropertyViewModel",
                    "Property List fetched:\nsize: ${it.size}\ncontent [print only first]: ${it.firstOrNull()}"
                )
                _propertyList.value = it
            }
        }
    }

    /**
     * Todo, use ID as perameter
     */
    fun getPropertyDetail() {
        viewModelScope.launch {
            repository.getDetailProperty(0).collect {
                _propertyDetail.value = it
            }
        }
    }

}
