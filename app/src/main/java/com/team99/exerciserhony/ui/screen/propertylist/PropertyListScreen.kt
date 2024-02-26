package com.team99.exerciserhony.ui.screen.propertylist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.team99.exerciserhony.ui.theme.Grey
import com.team99.exerciserhony.ui.theme.Team99AndroidExerciseRhonyTheme

@Composable
fun PropertyListScreen(
    modifier: Modifier = Modifier,
    list: List<PropertyItemModel>,
    onClickItem: (Int) -> Unit
) {
    Surface(color = Grey) {
        LazyColumn(
            modifier = modifier,
        ) {
            items(
                items = list,
                key = { model -> model.id }) { item ->
                PropertyListItem(model = item) { onClickItem(item.id) }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPropertyListScreen() {
    Team99AndroidExerciseRhonyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            PropertyListScreen(
                list = PropertyItemModel.MOCK_LIST,
                onClickItem = {}
            )
        }
    }
}
