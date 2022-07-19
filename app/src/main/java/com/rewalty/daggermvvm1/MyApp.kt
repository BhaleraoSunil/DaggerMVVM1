package com.rewalty.daggermvvm1

import android.app.Application
import com.rewalty.daggermvvm1.di.ApplicationComponent
import com.rewalty.daggermvvm1.di.DaggerApplicationComponent

class MyApp : Application() {

    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().build()

    }
}