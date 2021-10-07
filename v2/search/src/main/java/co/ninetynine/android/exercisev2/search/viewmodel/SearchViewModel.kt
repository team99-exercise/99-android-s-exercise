package co.ninetynine.android.exercisev2.search.viewmodel

import android.app.Application
import androidx.lifecycle.*
import co.ninetynine.android.exercisev2.search.data.repository.SearchRepository
import co.ninetynine.android.exercisev2.search.model.ListingItem

class SearchViewModel(
    private val app: Application,
    private val repository: SearchRepository,
) : ViewModel() {
    private val _listingItems = MutableLiveData<List<ListingItem>>()
    val listingItems: LiveData<List<ListingItem>> = _listingItems

    init {
        fetchSearchResults()
    }

    private fun fetchSearchResults() {
        // TODO
    }

}

