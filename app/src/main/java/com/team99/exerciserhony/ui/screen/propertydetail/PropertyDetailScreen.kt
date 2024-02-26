package com.team99.exerciserhony.ui.screen.propertydetail

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.team99.exerciserhony.ui.theme.Team99AndroidExerciseRhonyTheme
import java.util.Locale


internal val EXPANDED_TOP_BAR_HEIGHT = 275.dp
internal val COLLAPSED_TOP_BAR_HEIGHT = 56.dp

@Composable
fun PropertyDetailScreen(
    modifier: Modifier = Modifier,
    model: PropertyDetailModel,
    onClickBack: () -> Unit
) {
    val listState = rememberLazyListState()
    val overlapHeightPx = with(LocalDensity.current) {
        EXPANDED_TOP_BAR_HEIGHT.toPx() - COLLAPSED_TOP_BAR_HEIGHT.toPx()
    }
    val isCollapsed: Boolean by remember {
        derivedStateOf {
            val isFirstItemHidden = listState.firstVisibleItemScrollOffset > overlapHeightPx
            isFirstItemHidden || listState.firstVisibleItemIndex > 0
        }
    }
    val handler = LocalUriHandler.current

    Box(modifier = modifier.fillMaxSize()) {
        PropertyDetailHeaderCollapsed(
            modifier = Modifier.zIndex(2f),
            isCollapsed = isCollapsed,
            propertyName = model.propertyName,
            onClickBack = onClickBack
        )
        LazyColumn(state = listState) {
            item {
                PropertyDetailHeaderExpanded(
                    painter = model.imagePainter,
                    onClickBack = onClickBack
                )
            }
            item {
                PropertyDetailBody(model = model) { coordinate ->
                    val lat = coordinate.first
                    val lng = coordinate.second
                    handler.openUri(
                        Uri.parse("geo:0,0?q=$lat,$lng(${model.propertyName})").toString()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPropertyDetailScreen() {
    Team99AndroidExerciseRhonyTheme {
        PropertyDetailScreen(model = PropertyDetailModel.MOCK, onClickBack = {})
    }
}
