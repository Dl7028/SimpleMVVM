package com.yks.simplemvvm.app


import android.app.Application
import android.content.Context
import com.yks.simplemvvm.BuildConfig

import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import kotlin.properties.Delegates


/**
 * @Description:    基类注入hilt 依赖
 * @Author:         Yu ki-r
 * @CreateDate:     2020/11/2 21:55
 */

@HiltAndroidApp
class MyApplication : Application() {


    companion object {
        var CONTEXT: Context by Delegates.notNull()
    }


    override fun onCreate() {
        super.onCreate()
        CONTEXT = applicationContext
        //DEBUG开关
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

    }
}