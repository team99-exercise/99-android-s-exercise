package com.team99.exerciserhony.ui.screen.propertydetail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.team99.exerciserhony.ui.theme.Team99AndroidExerciseRhonyTheme

@Composable
fun PropertyDetailScreen(modifier: Modifier = Modifier) {
    Text(
        text = "Hello !",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewPropertyListFragment() {
    Team99AndroidExerciseRhonyTheme {
        PropertyDetailScreen()
    }
}
