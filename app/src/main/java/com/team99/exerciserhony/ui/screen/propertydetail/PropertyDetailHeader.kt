package com.team99.exerciserhony.ui.screen.propertydetail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.team99.exerciserhony.ui.theme.Team99AndroidExerciseRhonyTheme

@Composable
internal fun PropertyDetailHeaderExpanded(
    painter: Painter,
    onClickBack: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(EXPANDED_TOP_BAR_HEIGHT),
        contentAlignment = Alignment.TopStart
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        IconButton(
            modifier = Modifier.padding(top = 36.dp),
            onClick = onClickBack
        ) {
            Image(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
    }
}

@Composable
internal fun PropertyDetailHeaderCollapsed(
    modifier: Modifier = Modifier,
    isCollapsed: Boolean,
    propertyName: String,
    onClickBack: () -> Unit
) {
    val color: Color by animateColorAsState(
        targetValue = if (isCollapsed) MaterialTheme.colorScheme.background else Color.Transparent,
        label = ""
    )
    Box(
        modifier = modifier
            .background(color)
            .fillMaxWidth()
            .padding(top = COLLAPSED_TOP_BAR_HEIGHT / 2)
            .height(COLLAPSED_TOP_BAR_HEIGHT),
        contentAlignment = Alignment.CenterStart
    ) {
        AnimatedVisibility(visible = isCollapsed) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    modifier = Modifier.padding(top = 1.dp),
                    onClick = onClickBack
                ) {
                    Image(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = null
                    )
                }
                Text(
                    fontWeight = FontWeight.W600,
                    fontSize = 16.sp,
                    text = propertyName
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPropertyDetailHeaderExpanded() {
    Team99AndroidExerciseRhonyTheme {
        PropertyDetailHeaderExpanded(
            painter = PropertyDetailModel.MOCK.imagePainter,
            onClickBack = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPropertyDetailHeaderCollapsed() {
    Team99AndroidExerciseRhonyTheme {
        PropertyDetailHeaderCollapsed(
            isCollapsed = true,
            propertyName = "Parkview Apartment",
            onClickBack = {}
        )
    }
}
