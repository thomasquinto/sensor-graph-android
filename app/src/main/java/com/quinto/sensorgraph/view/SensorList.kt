package com.quinto.sensorgraph.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SensorList(sensorNames: List<String>,
               selectedSensor: (String) -> Unit
) {
    Column {
        Text(
            text = "Sensors",
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(
                items = sensorNames,
                itemContent = { sensorName ->
                    SensorListItem(
                        sensorName = sensorName,
                        selectedSensor = selectedSensor
                    )
                }
            )
        }
    }
}

@Composable
fun SensorListItem(
    sensorName: String,
    selectedSensor: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 4.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
    ) {
        Text(
            text = sensorName,
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable(onClick = { selectedSensor(sensorName) })
        )
    }
}

@Preview
@Composable
fun SensorListItemPreview() {
    SensorListItem(
        "Accelerometer",
        selectedSensor = { }
    )
}

@Preview
@Composable
fun SensorListPreview() {
    SensorList(
        sensorNames = listOf("Accelerometer", "Gyroscope", "Magnetometer"),
        selectedSensor = { }
    )
}