package com.designs.mybeautifuldesigns.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import designs.mybeautifuldesigns.BuildConfig
import timber.log.Timber

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 16/08/2022.
 */
@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}