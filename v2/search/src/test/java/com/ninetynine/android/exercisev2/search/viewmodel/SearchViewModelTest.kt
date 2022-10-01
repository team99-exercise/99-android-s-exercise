package com.ninetynine.android.exercisev2.search.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import co.ninetynine.android.exercisev2.search.data.repository.SearchRepository
import co.ninetynine.android.exercisev2.search.model.Address
import co.ninetynine.android.exercisev2.search.model.Attributes
import co.ninetynine.android.exercisev2.search.model.ListingItem
import co.ninetynine.android.exercisev2.search.viewmodel.SearchViewModel
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchViewModelTest {
    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var searchViewModel: SearchViewModel

    private val mockModel = ListingItem(
        projectName = "Parkview Apartments",
        address = Address(
            district = "D13",
            streetName = "12 Meyappa Chettiar Rd",
        ),
        category = "Exec Condo",
        tenure = 99,
        completedAt = "2020",
        attributes = Attributes(
            areaSize = 2561,
            bathrooms = 2,
            bedrooms = 3,
            price = 5700
        ),
        id = 1,
        photoUrl = ""
    )

    private val searchRepo = mockk<SearchRepository>()

    @Before
    fun setup() {
        searchViewModel = SearchViewModel(searchRepo)
    }

    @Test
    fun `Result are returned successfully, then published data to Live Data`() = runTest {
        coEvery { searchRepo.getSearchResults() } returns listOf(mockModel)

        advanceUntilIdle()
        val result = searchViewModel.listingItems.getOrAwaitValue()
        Truth.assertThat(result.data).hasSize(1)
        Truth.assertThat(result.data).contains(mockModel)
        Truth.assertThat(result.isLoading).isFalse()
        Truth.assertThat(result.error).isNull()
    }

    @Test
    fun `Error getting result, then published error to Live Data`() = runTest {
        coEvery { searchRepo.getSearchResults() } throws IllegalStateException()

        advanceUntilIdle()
        val result = searchViewModel.listingItems.getOrAwaitValue()
        Truth.assertThat(result.data).isNull()
        Truth.assertThat(result.isLoading).isFalse()
        Truth.assertThat(result.error).isInstanceOf(IllegalStateException::class.java)
    }
}