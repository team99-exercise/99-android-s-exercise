package com.frenzelts.team99.common

import com.frenzelts.team99.common.di.AppModule
import android.app.Application
import com.frenzelts.team99.common.di.DaggerAppComponent

class BaseApplication: Application() {

    val appComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule())
            .build()
    }

}