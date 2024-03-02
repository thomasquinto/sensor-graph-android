package com.quinto.sensorgraph

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.quinto.sensorgraph.model.AccelerometerSensorViewModel
import com.quinto.sensorgraph.model.GyroscopeSensorViewModel
import com.quinto.sensorgraph.model.MagnetometerSensorViewModel
import com.quinto.sensorgraph.sensor.AndroidSensor.Companion.ACCELEROMETER_SENSOR_NAME
import com.quinto.sensorgraph.sensor.AndroidSensor.Companion.GYROSCOPE_SENSOR_NAME
import com.quinto.sensorgraph.sensor.AndroidSensor.Companion.MAGNETOMETER_SENSOR_NAME
import com.quinto.sensorgraph.ui.theme.SensorGraphTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SensorGraphTheme {
                val viewModelMap = mapOf(
                    ACCELEROMETER_SENSOR_NAME to viewModel<AccelerometerSensorViewModel>(),
                    GYROSCOPE_SENSOR_NAME to viewModel<GyroscopeSensorViewModel>(),
                    MAGNETOMETER_SENSOR_NAME to viewModel<MagnetometerSensorViewModel>()
                )

                AppNavigation(viewModelMap)
            }
        }
    }
}
