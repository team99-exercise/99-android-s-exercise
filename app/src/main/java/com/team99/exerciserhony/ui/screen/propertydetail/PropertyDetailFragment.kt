package com.team99.exerciserhony.ui.screen.propertydetail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.team99.exerciserhony.ui.components.LoadingCircular
import com.team99.exerciserhony.ui.theme.Team99AndroidExerciseRhonyTheme
import com.team99.exerciserhony.viewmodel.PropertyViewModel

@Composable
fun PropertyDetailFragment(
    viewModel: PropertyViewModel = hiltViewModel(),
    propId: Int,
    navController: NavController
) {
    viewModel.getPropertyDetail(propId)
    val propertyDetail by viewModel.propertyDetail.collectAsStateWithLifecycle()
    PropertyDetailContainer(
        model = propertyDetail,
        onClickBack = {
            navController.popBackStack()
        }
    )
}

@Composable
fun PropertyDetailContainer(
    modifier: Modifier = Modifier,
    model: PropertyDetailModel?,
    onClickBack: () -> Unit
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        if (model == null) {
            LoadingCircular(Modifier.fillMaxSize())
            return@Surface
        }
        PropertyDetailScreen(model = model, onClickBack = onClickBack)
    }
}

@Preview(showBackground = true, name = "Detail Result")
@Composable
fun PreviewPropertyDetailContainer() {
    Team99AndroidExerciseRhonyTheme {
        PropertyDetailContainer(
            model = PropertyDetailModel.MOCK,
            onClickBack = {}
        )
    }
}

@Preview(showBackground = true, name = "Empty")
@Composable
fun PreviewPropertyDetailContainerEmpty() {
    Team99AndroidExerciseRhonyTheme {
        PropertyDetailContainer(model = null, onClickBack = {})
    }
}
