package com.quinto.sensorgraph

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.quinto.sensorgraph.model.MagnetometerSensorViewModel
import com.quinto.sensorgraph.ui.theme.SensorGraphTheme
import com.quinto.sensorgraph.view.SensorGraphView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SensorGraphTheme {
                val viewModel = viewModel<MagnetometerSensorViewModel>()
                val xValues = mutableListOf<Number>()
                val yValues = mutableListOf<Number>()
                val zValues = mutableListOf<Number>()
                val maxSize = 12
                SensorGraphView(viewModel, xValues, yValues, zValues, maxSize)
            }
        }
    }
}
