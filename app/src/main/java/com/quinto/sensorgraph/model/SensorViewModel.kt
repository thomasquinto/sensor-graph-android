package com.quinto.sensorgraph.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.quinto.sensorgraph.sensor.GyroscopeSensor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SensorViewModel @Inject constructor(
    val sensor: GyroscopeSensor
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

/*
class MainViewModel @Inject constructor(
    private val lightSensor: MeasurableSensor
): ViewModel() {

    var isDark by mutableStateOf(false)

    init {
        lightSensor.startListening { values ->
            val lux = values[0]
            isDark = lux < 60f
        }
    }
}
 */