package com.quinto.sensorgraph.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.quinto.sensorgraph.sensor.MeasurableSensor

abstract class SensorViewModel (
    val sensor: MeasurableSensor
): ViewModel() {

    var x by mutableFloatStateOf(0.0f)
    var y by mutableFloatStateOf(0.0f)
    var z by mutableFloatStateOf(0.0f)

    init {
        sensor.startListening { values ->
            x = values[0]
            y = values[1]
            z = values[2]
        }
    }
}

