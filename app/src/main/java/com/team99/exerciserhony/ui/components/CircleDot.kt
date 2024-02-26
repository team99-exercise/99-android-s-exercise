package com.team99.exerciserhony.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.team99.exerciserhony.ui.theme.Grey92
import com.team99.exerciserhony.ui.theme.Team99AndroidExerciseRhonyTheme

@Composable
fun CircleDot(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier.size(2.dp),
        onDraw = {
            drawCircle(color = Grey92)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCircleDot() {
    Team99AndroidExerciseRhonyTheme {
        Surface(
            modifier = Modifier
                .width(300.dp)
                .height(500.dp)
        ) {
            CircleDot()
        }

    }
}
