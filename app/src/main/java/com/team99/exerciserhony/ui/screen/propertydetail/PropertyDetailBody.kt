package com.team99.exerciserhony.ui.screen.propertydetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.team99.exerciserhony.R
import com.team99.exerciserhony.ui.theme.Grey92
import com.team99.exerciserhony.ui.theme.Grey92_ALPHA_33
import com.team99.exerciserhony.ui.theme.SeaBlue
import com.team99.exerciserhony.ui.theme.Team99AndroidExerciseRhonyTheme

@Composable
internal fun PropertyDetailBody(
    modifier: Modifier = Modifier,
    model: PropertyDetailModel,
    onClickMap: (Pair<Double, Double>) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(start = 8.dp, top = 16.dp, end = 8.dp)
    ) {
        Text(
            fontSize = 16.sp,
            fontWeight = FontWeight.W700,
            text = model.price
        )
        Text(
            modifier = Modifier.padding(top = 12.dp),
            fontWeight = FontWeight.W600,
            fontSize = 19.sp,
            text = model.propertyName
        )
        Text(
            modifier = Modifier.padding(top = 12.dp),
            color = Grey92,
            fontSize = 14.sp,
            fontWeight = FontWeight.W500,
            text = model.addressTitle
        )
        Text(
            modifier = Modifier.padding(top = 4.dp),
            color = Grey92,
            fontSize = 14.sp,
            fontWeight = FontWeight.W500,
            text = model.addressSubTitle
        )
        TextButton(
            contentPadding = PaddingValues(),
            onClick = { onClickMap(model.coordinate) }) {
            Icon(
                imageVector = Icons.Filled.Place,
                contentDescription = "",
                tint = SeaBlue
            )
            Text(
                color = SeaBlue,
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                text = stringResource(id = R.string.view_on_map)
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconText(
                painter = painterResource(id = R.drawable.bed), text = model.bedrooms
            )
            IconText(
                painter = painterResource(id = R.drawable.bath), text = model.bathrooms
            )
            IconText(
                painter = painterResource(id = R.drawable.floor_area), text = model.area
            )
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 2.dp, top = 12.dp),
            color = Grey92_ALPHA_33
        )
        PropertyDetailsSection(model = model)
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 2.dp, top = 12.dp),
            color = Grey92_ALPHA_33
        )
        Text(
            modifier = Modifier.padding(top = 16.dp),
            fontWeight = FontWeight.W600,
            fontSize = 19.sp,
            text = stringResource(id = R.string.description)
        )
        Text(
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
            fontWeight = FontWeight.W400,
            fontSize = 16.sp,
            text = model.description
        )
    }
}

@Composable
private fun IconText(painter: Painter, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier.size(16.dp),
            painter = painter,
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(start = 4.dp, end = 8.dp),
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
        )
    }
}

@Composable
private fun PropertyDetailsSection(
    modifier: Modifier = Modifier,
    model: PropertyDetailModel
) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(top = 16.dp),
            fontWeight = FontWeight.W600,
            fontSize = 19.sp,
            text = model.propertyName
        )
        PropDetailsRow(
            label = stringResource(id = R.string.price_sqft),
            value = model.detailSection.priceSqft
        )
        PropDetailsRow(
            label = stringResource(id = R.string.floor_level),
            value = model.detailSection.floorLevel
        )
        PropDetailsRow(
            label = stringResource(id = R.string.furnishing),
            value = model.detailSection.furnishing
        )
        PropDetailsRow(
            label = stringResource(id = R.string.facing),
            value = model.detailSection.facing
        )
        PropDetailsRow(
            label = stringResource(id = R.string.overlooking_view),
            value = model.detailSection.overlookingView
        )
        PropDetailsRow(
            label = stringResource(id = R.string.build_year),
            value = model.detailSection.buildYear
        )
        PropDetailsRow(
            label = stringResource(id = R.string.tenure),
            value = model.detailSection.tenure
        )
        PropDetailsRow(
            label = stringResource(id = R.string.property_type),
            value = model.detailSection.type
        )
        PropDetailsRow(
            label = stringResource(id = R.string.last_updated),
            value = model.detailSection.lastUpdated
        )
    }
}

@Composable
private fun PropDetailsRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
    ) {
        Text(
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.W500,
            fontSize = 16.sp,
            text = label
        )
        Text(
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.W400,
            fontSize = 16.sp,
            text = value
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPropertyDetailBody() {
    Team99AndroidExerciseRhonyTheme {
        PropertyDetailBody(
            model = PropertyDetailModel.MOCK,
            onClickMap = {}
        )
    }
}
