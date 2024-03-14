package com.frenzelts.team99

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.frenzelts.team99.common.Result
import com.frenzelts.team99.search.domain.ListingResponse
import com.frenzelts.team99.search.domain.SearchRepository
import com.frenzelts.team99.search.viewmodel.SearchViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

@ExperimentalCoroutinesApi
class SearchResultViewModelTest {

    private lateinit var viewModel: SearchViewModel
    private lateinit var repository: SearchRepository

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Before
    fun setUp() {
        repository = mockk()
        viewModel = SearchViewModel(repository)
        Dispatchers.setMain(testCoroutineRule.testDispatcher)
    }

    @Test
    fun testSuccessFetchData() = runTest {
        coEvery { repository.fetchRemote() } returns listOf(ListingResponse(id = 123L))

        viewModel.fetchSearchResult()

        assertEquals(viewModel.listing.value.status, Result.Status.SUCCESS)
    }

    @Test
    fun testErrorFetchData() = runTest {
        coEvery { repository.fetchRemote() } throws Exception()

        viewModel.fetchSearchResult()

        assertEquals(viewModel.listing.value.status, Result.Status.ERROR)
    }
}