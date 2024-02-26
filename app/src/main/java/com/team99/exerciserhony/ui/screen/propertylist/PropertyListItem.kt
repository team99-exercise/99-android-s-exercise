@file:OptIn(ExperimentalMaterial3Api::class)

package com.team99.exerciserhony.ui.screen.propertylist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.team99.exerciserhony.ui.components.CircleDot
import com.team99.exerciserhony.ui.theme.Grey92
import com.team99.exerciserhony.ui.theme.Team99AndroidExerciseRhonyTheme

@Composable
fun PropertyListItem(
    modifier: Modifier = Modifier,
    model: PropertyItemModel,
    onClickItem: () -> Unit
) {
    ElevatedCard(
        onClick = onClickItem,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(8.dp)),
                painter = model.imagePainter,
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(top = 12.dp),
                fontWeight = FontWeight.W600,
                fontSize = 16.sp,
                text = model.name
            )
            Row(
                modifier = Modifier.padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    color = Grey92,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W500,
                    text = model.streetName
                )
                CircleDot(Modifier.padding(start = 4.dp, end = 4.dp))
                Text(
                    color = Grey92,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W500,
                    text = model.district
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 2.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    color = Grey92,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W500,
                    text = model.category
                )
                CircleDot(Modifier.padding(start = 4.dp, end = 4.dp))
                Text(
                    color = Grey92,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W500,
                    text = model.completedAt
                )
                CircleDot(Modifier.padding(start = 4.dp, end = 4.dp))
                Text(
                    color = Grey92,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W500,
                    text = model.tenure
                )
            }
            Row(
                modifier = Modifier.padding(top = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = model.bedrooms,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                )
                CircleDot(Modifier.padding(start = 8.dp, end = 8.dp))
                Text(
                    text = model.bathrooms,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                )
                CircleDot(Modifier.padding(start = 8.dp, end = 8.dp))
                Text(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    text = model.area
                )
            }
            Text(
                modifier = Modifier.padding(top = 16.dp, bottom = 4.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.W700,
                text = model.price
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPropertyListItem() {
    Team99AndroidExerciseRhonyTheme {
        PropertyListItem(
            model = PropertyItemModel.MOCK,
            onClickItem = {}
        )
    }
}
