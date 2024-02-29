package com.quinto.sensorgraph.sensor

abstract class MeasurableSensor(
    protected val sensorType: Int,
    val name: String
) {
    protected var onSensorValuesChanged: ((List<Float>) -> Unit)? = null

    abstract val doesSensorExist: Boolean

    open fun startListening(listener: (List<Float>) -> Unit) {
        onSensorValuesChanged = listener
    }

    abstract fun stopListening()
}