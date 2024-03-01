package com.quinto.sensorgraph.sensor

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor


class AccelerometerSensor(
    context: Context
): AndroidSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_ACCELEROMETER,
    sensorType = Sensor.TYPE_ACCELEROMETER,
    name = AndroidSensor.ACCELEROMETER_SENSOR_NAME
)

class GyroscopeSensor(
    context: Context
): AndroidSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_GYROSCOPE,
    sensorType = Sensor.TYPE_GYROSCOPE,
    name = AndroidSensor.GYROSCOPE_SENSOR_NAME
)

class LightSensor(
    context: Context
): AndroidSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_LIGHT,
    sensorType = Sensor.TYPE_LIGHT,
    name = AndroidSensor.LIGHT_SENSOR_NAME
)

class MagnetometerSensor(
    context: Context
): AndroidSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_COMPASS,
    sensorType = Sensor.TYPE_MAGNETIC_FIELD,
    name = AndroidSensor.MAGNETOMETER_SENSOR_NAME
)
