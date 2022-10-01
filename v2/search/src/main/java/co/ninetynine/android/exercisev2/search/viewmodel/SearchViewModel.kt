package co.ninetynine.android.exercisev2.search.viewmodel

import androidx.lifecycle.*
import co.ninetynine.android.exercisev2.search.data.repository.SearchRepository
import co.ninetynine.android.exercisev2.search.model.ListingItem
import kotlinx.coroutines.launch

class SearchViewModel(
    private val repository: SearchRepository,
) : ViewModel() {
    private val _listingItems = MutableLiveData<State<List<ListingItem>>>()
    val listingItems: LiveData<State<List<ListingItem>>> = _listingItems

    init {
        fetchSearchResults()
    }

    private fun fetchSearchResults() = viewModelScope.launch {
        runCatching {
            _listingItems.postValue(State(isLoading = true))
            repository.getSearchResults()
        }.onSuccess {
            _listingItems.postValue(State(isLoading = false, data = it))
        }.onFailure {
            _listingItems.postValue(State(isLoading = false, error = it))
        }
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
