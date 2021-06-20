package com.qucoon.viewbindingapp.module

import android.app.Application
import com.qucoon.viewbindingapp.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
//        FirebaseApp.initializeApp(this);
        startKoin {
            androidContext(this@MyApplication)
            androidLogger(Level.DEBUG)
            modules(listOf(viewModelModule))
//            modules(listOf(repositoryModule, viewModelModule, networkModule, sharedclassmodule, dbModule))
        }
    }

    private fun initTimber(){
        if(BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}