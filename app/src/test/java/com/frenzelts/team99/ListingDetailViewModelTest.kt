package com.frenzelts.team99

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.frenzelts.team99.common.Result
import com.frenzelts.team99.listingdetail.domain.ListingDetailRepository
import com.frenzelts.team99.listingdetail.domain.ListingDetailResponse
import com.frenzelts.team99.listingdetail.view.model.BasicInfoUiModel
import com.frenzelts.team99.listingdetail.view.model.DescriptionUiModel
import com.frenzelts.team99.listingdetail.view.model.PropertyDetailUiModel
import com.frenzelts.team99.listingdetail.view.model.SectionSeparatorUiModel
import com.frenzelts.team99.listingdetail.view.model.SectionTitleUiModel
import com.frenzelts.team99.listingdetail.viewmodel.ListingDetailViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

@ExperimentalCoroutinesApi
class ListingDetailViewModelTest {

    private lateinit var viewModel: ListingDetailViewModel
    private lateinit var repository: ListingDetailRepository

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Before
    fun setUp() {
        repository = mockk()
        viewModel = ListingDetailViewModel(repository)
        Dispatchers.setMain(testCoroutineRule.testDispatcher)
    }

    @Test
    fun testSuccessFetchData() = runTest {
        val id = 123L
        coEvery { repository.fetchRemote(any()) } returns ListingDetailResponse(id = 123L)

        viewModel.fetchListingDetail(id)

        assertEquals(viewModel.listingDetail.value.status, Result.Status.SUCCESS)
        assertNotNull(viewModel.listingDetail.value.data?.any { it is BasicInfoUiModel })
        assertNotNull(viewModel.listingDetail.value.data?.any { it is PropertyDetailUiModel })
        assertNotNull(viewModel.listingDetail.value.data?.any { it is SectionTitleUiModel })
        assertNotNull(viewModel.listingDetail.value.data?.any { it is SectionSeparatorUiModel })
        assertNotNull(viewModel.listingDetail.value.data?.any { it is DescriptionUiModel })
    }

    @Test
    fun testErrorFetchData() = runTest {
        val id = 123L
        coEvery { repository.fetchRemote(any()) } throws Exception()

        viewModel.fetchListingDetail(id)

        assertEquals(viewModel.listingDetail.value.status, Result.Status.ERROR)
    }
}