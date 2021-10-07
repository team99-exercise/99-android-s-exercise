package co.ninetynine.android.exercisev2.search.viewmodel

import android.app.Application
import androidx.lifecycle.*
import co.ninetynine.android.exercisev2.search.model.ListingItem
import kotlinx.coroutines.launch

class SearchViewModel(
    private val app: Application,
) : ViewModel() {
    private val _listingItems = MutableLiveData<List<ListingItem>>()
    val listingItems: LiveData<List<ListingItem>> = _listingItems

    init {
        viewModelScope.launch {
            fetchSearchResults()
        }
    }

    private suspend fun fetchSearchResults() {
        // TODO()
    }

}

class SearchViewModelFactory(
    private val app: Application,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            return SearchViewModel(app) as T
        }
        throw IllegalArgumentException("Cannot create `SearchViewModel` from class: ${modelClass.name}")
    }
}
