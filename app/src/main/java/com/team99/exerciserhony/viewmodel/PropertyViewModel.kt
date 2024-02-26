package com.team99.exerciserhony.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team99.exerciserhony.domain.entity.Property
import com.team99.exerciserhony.domain.entity.PropertyDetail
import com.team99.exerciserhony.domain.repository.PropertyRepository
import com.team99.exerciserhony.ui.screen.propertydetail.PropertyDetailModel
import com.team99.exerciserhony.ui.screen.propertylist.PropertyItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertyViewModel @Inject constructor(
    private val repository: PropertyRepository
) : ViewModel() {

    private val _propertyList = MutableStateFlow(emptyList<PropertyItemModel>())
    val propertyList = _propertyList.asStateFlow()

    private val _propertyDetail = MutableStateFlow<PropertyDetailModel?>(null)
    val propertyDetail = _propertyDetail.asStateFlow()

    fun getPropertyList() {
        viewModelScope.launch {
            repository.getPropertyList().collect { entity ->
                Log.d(
                    "PropertyViewModel",
                    "Property List fetched:\nsize: ${entity.size}\ncontent [print only first]: ${entity.firstOrNull()}"
                )
                _propertyList.value = entity.map(PropertyItemModel::parseEntity)
            }
        }
    }

    /**
     * Todo, use ID as perameter
     */
    fun getPropertyDetail(id: Int) {
        viewModelScope.launch {
            repository.getDetailProperty(0).collect {
                _propertyDetail.value = PropertyDetailModel.parseEntity(it)
            }
        }
    }

}
