@file:Suppress("unused")

package com.edisiswanto.soccerteam

import android.app.Application
import com.edisiswanto.core.di.databaseModule
import com.edisiswanto.core.di.networkModule
import com.edisiswanto.core.di.repositoryModule
import com.edisiswanto.soccerteam.di.useCaseModule
import com.edisiswanto.soccerteam.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}