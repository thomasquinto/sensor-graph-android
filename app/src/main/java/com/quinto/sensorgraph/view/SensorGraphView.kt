package com.quinto.sensorgraph.view

import android.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.core.chart.line.LineChart
import com.patrykandpatrick.vico.core.entry.FloatEntry
import com.patrykandpatrick.vico.core.entry.entryModelOf
import com.quinto.sensorgraph.model.AccelerometerSensorViewModel
import com.quinto.sensorgraph.model.SensorViewModel
import com.quinto.sensorgraph.sensor.AccelerometerSensor

@Composable
fun SensorGraphView(
    viewModel: SensorViewModel,
    xValues: MutableList<Number>,
    yValues: MutableList<Number>,
    zValues: MutableList<Number>,
    maxSize: Int
) {

    xValues.add(viewModel.x)
    if (xValues.size > maxSize) {
        xValues.removeAt(0)
    }
    yValues.add(viewModel.y)
    if (yValues.size > maxSize) {
        yValues.removeAt(0)
    }
    zValues.add(viewModel.z)
    if (zValues.size > maxSize) {
        zValues.removeAt(0)
    }

    val xFloatEntries = xValues.mapIndexed { index, number ->
        FloatEntry(index.toFloat(), number.toFloat())
    }
    val yFloatEntries = yValues.mapIndexed { index, number ->
        FloatEntry(index.toFloat(), number.toFloat())
    }
    val zFloatEntries = zValues.mapIndexed { index, number ->
        FloatEntry(index.toFloat(), number.toFloat())
    }

    val chartEntryModel = entryModelOf(
        xFloatEntries, yFloatEntries, zFloatEntries
    )

    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            Text(viewModel.sensor.name,
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                modifier = Modifier.padding(16.dp)
            )

            val xLineSpec = LineChart.LineSpec(
                lineColor = Color.GREEN,
                lineThicknessDp = 3f
            )
            val yLineSpec = LineChart.LineSpec(
                lineColor = Color.MAGENTA,
                lineThicknessDp = 3f
            )
            val zLineSpec = LineChart.LineSpec(
                lineColor = Color.RED,
                lineThicknessDp = 3f
            )
            val lineSpecs = listOf(xLineSpec, yLineSpec, zLineSpec)

            Chart(
                chart = lineChart(lines = lineSpecs),
                model = chartEntryModel
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SensorGraphViewPreview() {
    SensorGraphView(
        AccelerometerSensorViewModel(
            sensor = AccelerometerSensor(LocalContext.current)
        ),
        mutableListOf(1, 2, 3, 4),
        mutableListOf(2, 3, 4, 1),
        mutableListOf(4, 2, 1, 3),
        12
    )
}