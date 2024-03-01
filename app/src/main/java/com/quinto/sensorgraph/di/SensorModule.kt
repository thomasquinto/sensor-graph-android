package com.quinto.sensorgraph.di

import android.app.Application
import com.quinto.sensorgraph.sensor.AccelerometerSensor
import com.quinto.sensorgraph.sensor.GyroscopeSensor
import com.quinto.sensorgraph.sensor.LightSensor
import com.quinto.sensorgraph.sensor.MagnetometerSensor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SensorModule {

    @Provides
    @Singleton
    fun provideAccelerometerSensor(app: Application): AccelerometerSensor {
        return AccelerometerSensor(app)
    }

    @Provides
    @Singleton
    fun provideGyroscopeSensor(app: Application): GyroscopeSensor {
        return GyroscopeSensor(app)
    }

    @Provides
    @Singleton
    fun provideLightSensor(app: Application): LightSensor {
        return LightSensor(app)
    }

    @Provides
    @Singleton
    fun provideMagnetometerSensor(app: Application): MagnetometerSensor {
        return MagnetometerSensor(app)
    }

}