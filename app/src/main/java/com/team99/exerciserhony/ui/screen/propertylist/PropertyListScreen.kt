package com.team99.exerciserhony.ui.screen.propertylist

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.team99.exerciserhony.ui.theme.Team99AndroidExerciseRhonyTheme
import com.team99.exerciserhony.viewmodel.PropertyViewModel

@Composable
fun PropertyListScreen(
    modifier: Modifier = Modifier,
    viewModel: PropertyViewModel = hiltViewModel(),
    onOpenPropertyDetail: () -> Unit
) {
    viewModel.getPropertyList()
    Text(
        text = "Hello !",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewPropertyListFragment() {
    Team99AndroidExerciseRhonyTheme {
        PropertyListScreen {}
    }
}
