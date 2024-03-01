package com.quinto.sensorgraph.model

import com.quinto.sensorgraph.sensor.AccelerometerSensor
import com.quinto.sensorgraph.sensor.GyroscopeSensor
import com.quinto.sensorgraph.sensor.LightSensor
import com.quinto.sensorgraph.sensor.MagnetometerSensor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccelerometerSensorViewModel @Inject constructor(
    sensor: AccelerometerSensor
): SensorViewModel(
    sensor = sensor
)

@HiltViewModel
class GyroscopeSensorViewModel @Inject constructor(
    sensor: GyroscopeSensor
): SensorViewModel(
    sensor = sensor
)

@HiltViewModel
class LightSensorViewModel @Inject constructor(
    sensor: LightSensor
): SensorViewModel(
    sensor = sensor
)

@HiltViewModel
class MagnetometerSensorViewModel @Inject constructor(
    sensor: MagnetometerSensor
): SensorViewModel(
    sensor = sensor
)