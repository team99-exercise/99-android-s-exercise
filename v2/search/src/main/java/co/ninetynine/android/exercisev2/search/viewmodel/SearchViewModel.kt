package co.ninetynine.android.exercisev2.search.viewmodel

import androidx.lifecycle.*
import co.ninetynine.android.exercisev2.search.data.repository.SearchRepository
import co.ninetynine.android.exercisev2.search.model.ListingItem
import kotlinx.coroutines.launch

class SearchViewModel(
    private val repository: SearchRepository,
) : ViewModel() {
    private val _listingItems = MutableLiveData<List<ListingItem>>()
    val listingItems: LiveData<List<ListingItem>> = _listingItems

    init {
        fetchSearchResults()
    }

    private fun fetchSearchResults() = viewModelScope.launch {
        val searchResults = repository.getSearchResults()
        _listingItems.postValue(searchResults)
    }
}

class SearchViewModelFactory(
    private val repository: SearchRepository,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            return SearchViewModel(repository) as T
        }
        throw IllegalArgumentException("Cannot create `SearchViewModel` from class: ${modelClass.name}")
    }
}
