package com.example.chocolatefactory

import android.app.Application
import com.example.chocolatefactory.common.HyperlinkedDebugTree
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class ChocolateApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()

        if(BuildConfig.DEBUG){
            Timber.plant(HyperlinkedDebugTree())
        }
    }


}