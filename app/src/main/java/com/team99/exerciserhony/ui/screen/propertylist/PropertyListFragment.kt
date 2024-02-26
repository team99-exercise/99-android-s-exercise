@file:OptIn(ExperimentalMaterial3Api::class)

package com.team99.exerciserhony.ui.screen.propertylist

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.team99.exerciserhony.R
import com.team99.exerciserhony.ui.components.LoadingCircular
import com.team99.exerciserhony.ui.screen.navigation.NavigationItem
import com.team99.exerciserhony.ui.theme.Grey92_ALPHA_99
import com.team99.exerciserhony.ui.theme.Team99AndroidExerciseRhonyTheme
import com.team99.exerciserhony.viewmodel.PropertyViewModel

@Composable
fun PropertyListFragment(
    viewModel: PropertyViewModel = hiltViewModel(),
    navController: NavController
) {
    viewModel.getPropertyList()
    val propertyList by viewModel.propertyList.collectAsStateWithLifecycle()
    PropertyListContainer(
        list = propertyList,
        onClickDetail = { propsId ->
            navController.navigate(NavigationItem.PropertyDetail.route)
        }
    )
}

@Composable
fun PropertyListContainer(
    modifier: Modifier = Modifier,
    list: List<PropertyItemModel>,
    onClickDetail: (Int) -> Unit
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.size(18.dp))
            Text(
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = stringResource(id = R.string.search_result)
            )
            Spacer(modifier = Modifier.size(18.dp))
            Canvas(modifier = Modifier.fillMaxWidth()) {
                drawLine(
                    start = Offset(x = 0f, y = 0f),
                    end = Offset(x = size.width, y = 0f),
                    color = Grey92_ALPHA_99
                )
            }
            if (list.isEmpty()) {
                LoadingCircular(Modifier.fillMaxSize())
            } else PropertyListScreen(
                modifier = Modifier.padding(top = 8.dp),
                list = list,
                onClickItem = onClickDetail
            )
        }
    }
}

@Preview(showBackground = true, name = "Empty")
@Composable
fun PreviewEmptyPropertyListContainer() {
    Team99AndroidExerciseRhonyTheme {
        PropertyListContainer(
            list = emptyList(),
            onClickDetail = {}
        )
    }
}

@Preview(showBackground = true, name = "Search Result")
@Composable
fun PreviewPropertyListContainer() {
    Team99AndroidExerciseRhonyTheme {
        PropertyListContainer(
            list = PropertyItemModel.MOCK_LIST,
            onClickDetail = {}
        )
    }
}
